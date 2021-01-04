package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        if (S == null || S.isEmpty()) {
            return Collections.emptyList();
        }

        int[] arr = new int[26]; // a-z chars only in S
        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i) - 'a'] = i; // mark the last location of each character
        }
        int last = 0;
        int start = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, arr[S.charAt(i) - 'a']);
            if (last == i) {
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }

    public List<Integer> partitionLabelsTwoPointer(String S) {

        if (S == null || S.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> map = new HashMap<>(); // a-z chars only in S
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1); // mark the last location of each character
        }

        int last = 0;
        int start = 0;
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> curMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            // ababcbaca
            if (!curMap.containsKey(S.charAt(i))) {
                curMap.put(S.charAt(i), map.get(S.charAt(i)));
            }
            curMap.put(S.charAt(i), curMap.get(S.charAt(i)) - 1);

            if (curMap.get(S.charAt(i)) == 0) {
                curMap.remove(S.charAt(i));
            }

            if (curMap.keySet()
                      .size() == 0) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
