package com.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    Map<Integer, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        return recursive(0, s);
    }

    int recursive(int index, String s) {
        int total = 0;
        if (index >= s.length()) {
            return 1;
        }
        if (!map.containsKey(index)) {
            for (int i = 1; i <= 2; i++) {
                if (index + i <= s.length()) {
                    String s1 = s.substring(index, index + i);
                    if (s1.charAt(0) == '0') {
                        continue;
                    }
                    if (Integer.parseInt(s1) <= 26) {
                        total += recursive(index + i, s);
                    }
                }
            }
            map.put(index, total);
        }
        return map.get(index);
    }
}
