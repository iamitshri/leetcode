package com.practice;

public class ThreeSumClosest2 {

    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * <p>
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * <p>
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    // O(n^3)
    public int threeSumClosest(int[] num, int target) {

		if (num == null) {
			return 0;
		}

        if (num.length < 3) {

            return 0;
        }

        int sum, n = num.length, min = Integer.MAX_VALUE;
        int minsum = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    sum = num[i] + num[j] + num[k];
                    int diff = Math.abs(target - sum);
                    if (diff < min) {
                        min = diff;
                        minsum = sum;
                    }
                }
            }

        }
        return minsum;

    }


}
