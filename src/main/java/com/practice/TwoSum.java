package com.practice;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	/**
	 * O(nlogn) time
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum_SortArray(int[] nums, int target) {
		Arrays.sort(nums);
		int[] ret = new int[2];
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] > target) {
				end--;
			} else if (nums[start] + nums[end] < target) {
				start++;
			} else {
				ret[0] = start;
				ret[1] = end;
				break;
			}
		}

		return ret;
	}

	/**
	 * O(n) space and O(n) time
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		if (nums == null || nums.length == 0)
			return ret;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				ret[0] = map.get(target - nums[i]);
				ret[1] = i;
				break;
			} else {
				map.put(nums[i], i);
			}
		}

		return ret;
	}

	/**
	 * 
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2. Please
	 * note that your returned answers (both index1 and index2) are not
	 * zero-based.
	 * 
	 * You may assume that each input would have exactly one solution.
	 * 
	 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		for (int i : new TwoSum().twoSum(new int[] { 3, 2, 4 }, 6)) {
			System.out.print(i);
		}
	}

	public int[] twoSum2(int[] numbers, int target) {

		if (numbers == null || numbers.length == 0)
			return new int[] {};

		int start = 0;
		int end = numbers.length - 1;

		for (int j = 0; j < numbers.length; j++) {

			for (int i = j + 1; i < numbers.length; i++) {
				int sum = numbers[i] + numbers[j];

				if (sum == target) {
					return new int[] { j + 1, i + 1 };
				}

			}

		}

		return new int[] {};
	}

}
