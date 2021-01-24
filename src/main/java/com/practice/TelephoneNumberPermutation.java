package com.practice;

import java.util.ArrayList;
import java.util.List;

public class TelephoneNumberPermutation {

	/**
	 * number to character mapping given. Return the all possible combinations
	 * of characters for given input integer array.
	 * 
	 */
	static int[][] intToChar = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' } };

	static List<String> result = new ArrayList<String>();

	static void getPossibleChars(int[] a, int start, StringBuilder sb) {
		// Handle
		if (sb.length() == a.length) {
			result.add(sb.toString());
			return;
		}
		// Build the string by considering each int once
		// Go through all of the mappings for this current integer
		for (int j = 0; start < intToChar.length && j < intToChar[a[start]].length; j++) {
			// Add the current character to the buffer
			sb.append((char) intToChar[a[start]][j]);
			getPossibleChars(a, start + 1, sb);
			// Remove the last added character
			sb.setLength(sb.length() - 1);
		}
	}

	public static void main(String[] s) {
		getPossibleChars(new int[] { 0, 1 }, 0, new StringBuilder());
		for (String re : result) {
			System.out.println(re);
		}

	}

}