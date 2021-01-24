package com.practice;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	/*
	 * Given a string, find the length of the longest substring without
	 * repeating characters.
	 * 
	 * Examples:
	 * 
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * 
	 * Given "bbbbb", the answer is "b", with the length of 1. abcdfgc 0123456 c
	 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
	 * answer must be a substring, "pwke" is a subsequence and not a substring.
	 */

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int max = 0;

		HashMap<Character, Integer> seen = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < s.toCharArray().length; i++) {
			if (seen.containsKey(s.charAt(i))) {
				j = Math.max(seen.get(s.charAt(i)) + 1, j);
			}
			seen.put(s.charAt(i), i);
			max = Math.max(i - j + 1, max);
		}
		return max;
	}

	public static void main(String[] args) {
		// abcdeafgabcbb
		System.out.println(lengthOfLongestSubstring("paadfdspwwkew"));
	}
}
