package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringWithKDistinctChars {

    public static void main(String[] args) {
        List<String> list = findKSizedSubstring("awaglknagawunagwkwagl", 4);
        list.forEach(System.out::println); // ab bc
    }

    /**
     * Input: s = "awaglknagawunagwkwagl", k = 4 Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun",
     * "wuna", "unag", "nagw", "agwk", "kwag"] Explanation: Substrings in order are: "wagl", "aglk", "glkn", "lkna",
     * "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" "wagl" is repeated twice, but is included
     * in the output once. https://leetcode.com/discuss/interview-question/370112/
     *
     * @param s
     * @param k
     * @return
     */
    public static List<String> findKSizedSubstring(String s, int k) {

        // validate the input
        if (s == null || s.length() == 0) {
            return Collections.emptyList();
        }

        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int end = 0; end < s.length(); end++) {
            // char frequency
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

            if (end - start + 1 >= k) {  // we found k size string
                // get # of duplicates
                int numElements = end - start + 1;
                while (numElements > k) {
                    char st = s.charAt(start);
                    map.put(st, map.get(st) - 1);
                    if (map.get(st) == 0) {
                        map.remove(st);
                    }
                    numElements--;
                    start++;
                }
                int numDuplicates = numElements - map.size();
                while (numDuplicates > 0) {
                    char st = s.charAt(start);
                    map.put(st, map.get(st) - 1);
                    if (map.get(st) == 0) {
                        map.remove(st);
                    }
                    numElements--;
                    numDuplicates = numElements - map.size();
                    start++;
                }
            }

            if (end - start + 1 == k) {

                // if no duplicates grab the window and add it to set
                String window = s.substring(start, end + 1);
                set.add(window);
                // shrink the window, until no duplicates
            }
        }
        return new ArrayList<>(set);
    }
}
