package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombination {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        String[][] map = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"},
            {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

        // helper("",digits,0,result,map);

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");
        while (queue.peek()
                    .length() != digits.length()) {
            String s = queue.remove();
            char digit = digits.charAt(s.length());
            for (int i = 0; i < map[(digit - '0')].length; i++) {
                String t = map[digit - '0'][i];
                queue.offer(s + t);
            }
        }

        return queue;
    }

    /**
     * DFS Approach
     * @param str
     * @param digits
     * @param start
     * @param result
     * @param map
     */
    void helper(String str, String digits, int start, List<String> result, String[][] map) {

        if (str.length() == digits.length()) {
            result.add(str);
            return;
        }
        char digit = digits.charAt(start);
        for (int i = 0; i < map[(digit - '0')].length; i++) {
            String t = map[digit - '0'][i];
            helper(str + t, digits, start + 1, result, map);
        }
    }

}
