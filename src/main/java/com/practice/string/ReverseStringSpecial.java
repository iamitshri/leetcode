package com.practice.string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 *
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 */
public class ReverseStringSpecial {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);  // reverse the whole string first
        int r = 0;
        // "t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"

        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ')
                r++;
            reverse(s, l, r-1);  // reverse words one by one
            r++;
        }
    }

    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}
