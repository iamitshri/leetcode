package com.practice;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
        int i = 0;
        int j = cols - 1;
        while (i < matrix.length && j >= 0) {

            int v = matrix[i][j];
            if (v == target) {
                return true;
            } else if (v > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean searchMatrixTreatMatrixAsSingleArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
        int start = 0;
        int end = rows * cols - 1;
        while (start <= end) {
            int m = (end - start) / 2 + start;
            int v = matrix[m / cols][m % cols];
            if (v == target) {
                return true;
            } else if (v > target) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }
        return false;
    }

    public boolean searchMatrixFindRowAndThenTarget(int[][] matrix, int target) {
        // O(mn)
        // O(mnlogn)
        // O(m)+(nlogn)
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
        int targetRow = -1;
        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                targetRow = i;
                break;
            }
        }

        if (targetRow != -1) {
            return binarySearch(matrix[targetRow], 0, cols - 1, target);
        }

        return false;
    }


    boolean binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int m = (end - start) / 2 + start;
            if (arr[m] == target) {
                return true;
            } else if (arr[m] > target) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }
        return false;
    }
}
