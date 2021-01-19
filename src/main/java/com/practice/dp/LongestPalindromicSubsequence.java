package com.practice.dp;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return subsequencePalin(s, 0, s.length() - 1, dp);
    }

    int subsequencePalin(String s, int startIndex, int endIndex, int[][] dp) {

        if (startIndex > endIndex) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }

        if (dp[startIndex][endIndex] == 0) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + subsequencePalin(s, startIndex + 1, endIndex - 1, dp);
            } else {
                int c1 = subsequencePalin(s, startIndex + 1, endIndex, dp);
                int c2 = subsequencePalin(s, startIndex, endIndex - 1, dp);
                dp[startIndex][endIndex] = Math.max(c1, c2);
            }
        }
        return dp[startIndex][endIndex];
    }
}
