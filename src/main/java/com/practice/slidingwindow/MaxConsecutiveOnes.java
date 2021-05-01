package com.practice.slidingwindow;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int start = 0;
        int numZero = 1;
        int zeros = 0;
        int max = 0;
        for (int end = 0; end < nums.length; end++) {

            if (nums[end] == 0) {
                zeros++;
            }
            while (zeros > numZero) {
                if (nums[start] == 0) {
                    zeros--;
                }
                start++;
            }
            max = Math.max(end - start + 1, max);
        }
        return max;
    }

}
