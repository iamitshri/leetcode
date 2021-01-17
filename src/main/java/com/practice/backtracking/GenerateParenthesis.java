package com.practice.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        recursive(result, "", n, 0, 0);
        return result;
    }


    void recursive(List<String> result, String s, int n, int open, int close) {
        if (s.length() == 2 * n) {
            result.add(s);
        } else {
            if (open < n) {
                recursive(result, s + "(", n, open + 1, close);
            }
            if (open > close) {
                recursive(result, s + ")", n, open, close + 1);
            }
        }
    }

    public List<String> generateParenthesisBFS(int n) {

        List<String> result = new ArrayList<>();
        LinkedList<Parenthesis> queue = new LinkedList<>();
        queue.add(new Parenthesis(0, 0, ""));
        // 2
        // (
        // () ((

        while (!queue.isEmpty()) {

            Parenthesis p = queue.poll();

            if (p.open == n && p.close == n) {
                result.add(p.s);
            } else {
                if (p.open < n) {
                    queue.add(new Parenthesis(p.open + 1, p.close, p.s + "("));
                }
                if (p.open > p.close) {
                    queue.add(new Parenthesis(p.open, p.close + 1, p.s + ")"));
                }
            }
        }

        return result;
    }

    class Parenthesis {

        int open;
        int close;
        String s;

        Parenthesis(int open, int close, String s) {
            this.open = open;
            this.close = close;
            this.s = s;
        }

        public String toString() {
            return this.open + " " + this.close + " " + this.s;
        }
    }
}