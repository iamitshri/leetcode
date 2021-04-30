package com.practice.array;

public class SquaresOfSortedArray {

    /**
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
     * in non-decreasing order.
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums is sorted in non-decreasing order.
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];
        int index = result.length - 1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int ls = nums[low] * nums[low];
            int hs = nums[high] * nums[high];
            if (ls > hs) {
                result[index] = ls;
                low++;
            } else {
                result[index] = hs;
                high--;
            }
            index--;
        }
        return result;
    }
}
