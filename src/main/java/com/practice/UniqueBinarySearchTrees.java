package com.practice;

public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		int sum = 0;
		if (n <= 1)
			return 1;
		else {

			for (int i = 1; i <= n; i++) {
				int left = numTrees(i - 1);
				int right = numTrees(n - i);
				sum += left * right;
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(new UniqueBinarySearchTrees().numTrees(3));

	}

}
