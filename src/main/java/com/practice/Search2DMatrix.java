package com.practice;

public class Search2DMatrix {

	/**
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3,
	 * return true.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0)
			return false;

		int numrows = matrix.length - 1;
		int numcols = matrix[0].length - 1;

		if (target > matrix[numrows][numcols] || target < matrix[0][0])
			return false;

		if (target == matrix[numrows][numcols] || target == matrix[0][0])
			return true;

		int i = 0;
		int j = numcols;
		while (i <= numrows && j >= 0) {
			if (target == matrix[i][j])
				return true;
			if (target < matrix[i][j])
				j--;
			else
				i++;
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
