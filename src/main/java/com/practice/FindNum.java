package com.practice;

import java.util.Arrays;

public class FindNum {
	static String findNumber(int[] arr, int k) {

		if (arr == null || arr.length == 0)
			return "NO";

		Arrays.sort(arr);

		if (Arrays.binarySearch(arr, k) >= 0) {
			return "YES";
		} else {
			return "NO";
		}

	}

	public static void main(String[] args) {
		System.out.println(FindNum.findNumber(new int[] { 1, 2, 3 }, 1));
	}
}
