package com.practice;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk {
	/*
	 * Given an array nums and a target value k, find the maximum length of a
	 * subarray that sums to k. If there isn't one, return 0 instead.
	 * 
	 * Note: The sum of the entire nums array is guaranteed to fit within the
	 * 32-bit signed integer range.
	 * 
	 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3, return 4. (because the
	 * subarray [1, -1, 5, -2] sums to 3 and is the longest)
	 * 
	 * Example 2: Given nums = [-2, -1, 2, 1], k = 1, return 2. (because the
	 * subarray [-1, 2] sums to 1 and is the longest)
	 * 
	 * Follow Up: Can you do it in O(n) time?
	 */
	public int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len=0;
		for (int i = 0; i < nums.length; i++) {
			for (Integer n : map.keySet()) {
				int currentSum = nums[i] + map.get(n);
				if (currentSum == k) {
					len = Math.max(i - n + 1, len);
				}
				map.put(n, currentSum);
			}
			if(nums[i]==k){
				len = Math.max(1, len);
			}
			map.put(i, nums[i]);
		}
					 
		return len;

	}

	public int maxSubArrayLen1(int[] nums, int k) {
		int sum = 0, max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum == k)
				max = i + 1;
			else if (map.containsKey(sum - k))
				max = Math.max(max, i - map.get(sum - k));
			
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSizeSubarraySumEqualsk m = new MaximumSizeSubarraySumEqualsk();
		int k = 11;
		int [] nums = new int []{7,5,1,-2,1,2,8,1};
		int result = m.maxSubArrayLen1(nums, k);
		
		
		System.out.println(result);
	}
}
