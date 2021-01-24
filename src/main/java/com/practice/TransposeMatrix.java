package com.practice;

public class TransposeMatrix {
	public static void transposeMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j > i) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}

	}
}
