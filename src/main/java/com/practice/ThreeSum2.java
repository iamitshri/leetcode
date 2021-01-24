package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum2 {

	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie,
	 * a � b � c) The solution set must not contain duplicate triplets. For
	 * example, given array S = {-1 0 1 2 -1 -4},
	 * 
	 * A solution set is: (-1, 0, 1) (-1, -1, 2)
	 */

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> intArr = new ArrayList<List<Integer>>();

		if (num == null)
			return null;

		if (num.length < 3) {

			return intArr;
		}
		int n = num.length;
		HashSet<ArrayList<Integer>> seen = new HashSet<ArrayList<Integer>>();
		int sum = 0;
		Arrays.sort(num);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1, k = n - 1; j < n && j < k;) {
				sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(num[i]);
					l.add(num[j]);
					l.add(num[k]);
					if (!seen.contains(l)) {
						intArr.add(l);
						seen.add((ArrayList<Integer>) l);
					}
				}
				if (sum < 0)
					j++;
				else
					k--;
			}
		}

		return intArr;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
