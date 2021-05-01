package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    /**
     * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in
     * the range [1, n] that do not appear in nums.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,3,2,7,8,2,3,1] Output: [5,6] Example 2:
     * <p>
     * Input: nums = [1,1] Output: [2]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length 1 <= n <= 105 1 <= nums[i] <= n
     * <p>
     * <p>
     * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not
     * count as extra space.
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {

            if (i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] - 1 != j) {
                result.add(j + 1);
            }
        }
        return result;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
