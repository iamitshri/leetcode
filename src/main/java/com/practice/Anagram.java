package com.practice;

public class Anagram {
	//
	public static boolean isAnagram(String input1, String input2) {
		if (input1 == null || input2 == null)
			return false;
		if (input1.length() != input2.length()) {
			return false;
		}
		int[] alphabets = new int[26];

		for (int i = 0; i < input1.length(); i++) {
			alphabets[input1.charAt(i) - 'a'] = 1;
		}
		for (int i = 0; i < input2.length(); i++) {

			if (alphabets[input2.charAt(i) - 'a'] != 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("akram", "mraka"));
	}
}
