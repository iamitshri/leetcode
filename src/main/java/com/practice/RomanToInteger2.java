package com.practice;

public class RomanToInteger2 {

	public static int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int num = 0;
		int prev = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int currVal = getValue(s.charAt(i));
			if (currVal < prev) {
				num -= currVal;
			} else {
				num += currVal;
			}
			prev = currVal;

		}

		return num;
	}

	static int getValue(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;

		return 0;
	}

	public static void main(String[] args) {
		int n = romanToInt("XXI");

		System.out.println(n);
	}
}