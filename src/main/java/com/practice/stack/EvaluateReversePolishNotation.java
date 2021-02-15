package com.practice.stack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!set.contains(token)) {
                stack.push(token);
            } else {
                int x = getAnswer(token, stack.pop(), stack.pop());
                stack.push("" + x);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    int getAnswer(String operator, String operand1, String operand2) {
        int o1 = Integer.parseInt(operand1);
        int o2 = Integer.parseInt(operand2);
        if (operator.equals("+")) {
            return o1 + o2;
        }
        if (operator.equals("-")) {
            return o2 - o1;
        }
        if (operator.equals("*")) {
            return o2 * o1;
        }
        if (operator.equals("/")) {
            return o2 / o1;
        }

        return 0;
    }

}
