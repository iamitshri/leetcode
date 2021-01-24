package com.practice;

public class MatrixReshape {

	public int[][] matrixReshape(int[][] nums, int r, int c) {

		if (nums == null || nums.length == 0)
			return nums;
		int numRows = nums.length;
		int numCols = nums[0].length;
		if (r * c > numRows * numCols) {
			return nums;
		}
		// 4 * 5
		// 10 * 2 , 2* 10,

		int[] cols = new int[c];
		int[][] rows = new int[r][];
		int cnt = 0;
		int rCnt = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				cols[cnt++] = nums[i][j];
				if (cnt >= c) {
					rows[rCnt++] = cols;
					cols = new int[c];
					cnt = 0;
				}
			}
		}
		return rows;
	}

}
