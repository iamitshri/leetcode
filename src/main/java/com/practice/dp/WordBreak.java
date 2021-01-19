package com.practice.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak1(String s, List<String> wordDict) {

        if (s.isEmpty()) {
            return true;
        }
        if (map.get(s) == null) {
            boolean result = false;
            for (int i = 1; i <= s.length() - 1; i++) {
                String part = s.substring(0, i);
                if (wordDict.contains(part)) {
                    result = wordBreak1(s.substring(i), wordDict);
                    if (result) {
                        return true;
                    }
                }
            }
            map.put(s, wordDict.contains(s));
        }
        return map.get(s);
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Map<Integer, Boolean> map = new HashMap<>();
        return helper(s, 0, new HashSet<>(wordDict), map);
    }

    boolean helper(String s, int start, HashSet<String> set, Map<Integer, Boolean> m) {

        if (start == s.length()) {
            return true;
        }

        if (m.get(start) != null) {
            return m.get(start);
        }

        m.put(start, false);
        for (int i = start + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i)) && helper(s, i, set, m)) {
                m.put(start, true);
            }
        }

        return m.get(start);
    }

    public boolean wordBreakDp(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
