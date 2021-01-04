package com.practice;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        // maximal square
        // length=width

        // line of thinking
        // area: length * width
        // len = (i1-i2) * (y1-y2)
        // square has same length
        // so max square is max length
        // each location in the dp matrix is max square at the location where i j is the lowest bottom corner

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        int len = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0 || matrix[i][j] == '0') {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
                len = Math.max(len, dp[i][j]);
            }
        }
        return len * len;
    }

}
