package com.practice;

public class ReverseBits {

	static int reverseBits(int n) {
		int result = 0;
		int i = 0;
		for (i = 0; i < 32; i++) {
			int temp = (n & (1 << (i)));
			if (temp > 0) {
				result |= (1 << (31 - i));
			}
		}
		return result;
	}

	static int reverseBits_1(int n) {
		int result = n;
		int cnt = 32;
		while (n > 0) {
			result <<= 1;
			result |= n & 1;
			n >>= 1;
			cnt--;
		}
		result = result << cnt;
		return result;
	}

	public static void main(String[] args) {

		System.out.println(reverseBits_1(43261596));
	}
	// 964176192 -->
}
