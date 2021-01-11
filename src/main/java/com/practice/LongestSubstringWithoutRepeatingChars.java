package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {

        int start = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        // aab
        for (int end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            // how do we know if we have seen the character before
            //remove from start until no more duplicate
            while (!set.add(curr)) {
                set.remove(s.charAt(start++));
            }
            maxLen = Math.max(maxLen, end - start + 1);
            // if the new character is seen, remove it until there is no duplicate in the current window
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringUsingMap(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
