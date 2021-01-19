package com.practice;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int maxSoFar = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSoFar += nums[i];
            maxSoFar = Math.max(nums[i], maxSoFar);
            maxSum = Math.max(maxSum, maxSoFar);
        }
        return maxSum;
    }
}
