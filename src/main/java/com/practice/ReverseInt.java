package com.practice;

public class ReverseInt {
	public static int reverseInt(int x) {

		boolean isNeg = false;
		if (x < 0) {
			isNeg = true;
			x = x * -1;
		}
		int reverseInt = 0;
		while (x != 0) {
			reverseInt = reverseInt * 10 + x % 10;
			x = x / 10;
		}
		return isNeg ? reverseInt * -1 : reverseInt;

	}

	/**
	 * This solution takes care of overflow or underflow
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		if (x == 0 || x >= Integer.MAX_VALUE)
			return 0;
		long num = 0;
		while (x != 0) {
			num = 10 * num + (x % 10);
			x = x / 10;
			if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
				return 0;
			}
		}
		return (int) num;

	}
}
