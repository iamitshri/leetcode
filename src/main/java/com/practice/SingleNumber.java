package com.practice;

/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


 */
public class SingleNumber {

	public int singleNumber(int[] A) {
		int xor = 0;
		if (A == null || A.length == 0)
			return 0;
		else {
			for (int i = 0; i < A.length; i++)
				xor ^= A[i];
		}
		return xor;
	}

	public static void main(String s[]) {
		int[] arr = new int[] { 12, 0, 0 };
		System.out.println(new SingleNumber().singleNumber(arr));
	}

}
