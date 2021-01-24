package com.practice;

import java.util.ArrayList;
import java.util.List;

public class ComputeBinaryRepresentation {
	public static String computeBinaryIterative(int val) {
		if (val == 0) {
			return "0";
		}
		String result = "";
		List<String> lst = new ArrayList<>();
		while (val > 0) {
			int i = val % 2;
			lst.add(String.valueOf(i));
			val = val / 2;
		}

		for (int i = lst.size() - 1; i >= 0; i--) {
			result = result + lst.get(i);
		}

		return result;
	}

	public static String computeBinary(int val) {
		// Base case: value is less than 2
		if (val < 2)
			return Integer.toString(val);
		// Recursive case: binary rep = binary of the header + last digit
		// (odd/even)
		else {
			return computeBinary(val / 2) + computeBinary(val % 2);
		}
	}

	public static void main(String[] args) {
		String r = computeBinary(3);
		System.out.println(r);
		System.out.println(4 & 1);

	}

}
