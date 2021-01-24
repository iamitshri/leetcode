package com.practice;

public class ReverseInteger {

	/**
	 * @param args
	 */

	public int reverse(int x) {

		// take care of single digit
		if (x / 10 == 0) {
			return x;
		}

		String s = Integer.toString(x);
		int sign = s.indexOf("-");

		if (sign != -1)
			s = s.replaceFirst("-", "");

		char[] arrs = s.toCharArray();

		reversestr(arrs, 0, s.length() - 1);

		String rev = new String(arrs);

		if (sign != -1)
			rev = "-".concat(rev);
		int revint = 0;

		try {
			revint = Integer.parseInt(rev);
		} catch (NumberFormatException e) {

		}
		return revint;

		// conver to string then reverse string and then convert to int again

	}

	public void reversestr(char[] arr, int start, int end) {

		if (arr == null || arr.length == 0 || start > end)
			return;

		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {

		System.out.println("" + new ReverseInteger().reverse(-21236789));

	}

}
