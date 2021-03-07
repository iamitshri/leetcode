package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * https://leetcode.com/problems/spiral-matrix/submissions/
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Right
            for (int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Down
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }

        return result;
    }
}
