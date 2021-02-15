package com.practice.dfs;

import java.util.Stack;

public class DecodeString {

    /**
     * https://leetcode.com/problems/decode-string/
     *
     * @param s
     * @return
     */
    public String decodeStringElegant(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) {
                    cur.append(tmp);
                }
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }

    public String decodeString(String s) {

        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                int[] result = new int[1];
                i = getDigit(i, s, result);
                int times = result[0];
                StringBuilder res = new StringBuilder();
                int index = getStringFrom(i + 1, s, res);
                while (times > 0) {
                    sb.append(res.toString());
                    times--;
                }
                i = index + 1;
            } else if (Character.isLetter(c)) {
                sb.append(c);
                i++;
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    int getStringFrom(int index, String str, StringBuilder sb) {
        while (index < str.length() && str.charAt(index) != ']') {

            if (Character.isDigit(str.charAt(index))) {
                int[] result = new int[1];
                index = getDigit(index, str, result);
                int times = result[0];
                StringBuilder res = new StringBuilder();
                int ind = getStringFrom(index + 1, str, res);
                while (times > 0) {
                    sb.append(res.toString());
                    times--;
                }
                index = ind + 1;
            } else {
                sb.append(str.charAt(index));
                index++;
            }

        }
        return index;
    }

    int getDigit(int start, String str, int[] result) {
        int res = 0;
        while (start < str.length() && Character.isDigit(str.charAt(start))) {
            res = res * 10 + (str.charAt(start) - '0');
            start++;
        }
        result[0] = res;
        return start;
    }

}
