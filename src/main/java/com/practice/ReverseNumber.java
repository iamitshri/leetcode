package com.practice;

public class ReverseNumber {
	public int reverse(int num) {
		// immediate notice
		// overflow underflow
		// sign needs to be preserved

		// 32 bit signed integer
		// FF FF FF FF

		long temp = 0;
		boolean isNeg = false;
		if (num < 0) {
			isNeg = true;
			num = num * -1;
		}
		while (num > 0) {
			long temp2 = (temp * 10) + num % 10;
			if (temp2 > Integer.MAX_VALUE) {
				return 0;
			}
			temp = temp2;
			num = num / 10;
		}
		if (isNeg) {
			temp = temp * -1;
		}
		return (int) temp;
	}

	public static void main(String[] args) {
		System.out.println(new ReverseNumber().reverse(1534236469));
	}
}
