package com.practice;

public class MaximumSubarray {
	/*
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
	 * subarray [4,−1,2,1] has the largest sum = 6.
	 */
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Input: [1,2,-1,-2,2,1,-2,1,4,-5,4] Output: 5 Expected: 6
		 */
		int[] A = new int[] { 1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4 };
		System.out.print(new MaximumSubarray().maxSubArray(A));
	}

	public int maxSubArray(int[] A) {

		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		int sumSoFar = 0, currSum = 0, max = 0;
		max = sumSoFar = currSum = A[0];
		for (int i = 1; i < A.length; i++) {

			currSum = Math.max(currSum + A[i], A[i]);

			if (max < currSum) {
				max = currSum;
			}

		}
		return max;

	}

}
