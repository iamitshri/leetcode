package com.practice;

import java.util.ArrayList;
import java.util.List;

public class LetterProblems {
	char[][] mapping = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
	List<String> result = new ArrayList<>();

	public void letterCombinations(String digits, int start, String str) {

		if (start >= digits.length()) {
			result.add(str);
			return;
		}
		int n = digits.charAt(start) - '0';
		if (mapping[n].length == 0) {
			letterCombinations(digits, start + 1, str);
		}
		for (int j = 0; j < mapping[n].length; j++) {
			letterCombinations(digits, start + 1, str + "" + mapping[n][j]);
		}
	}

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return result;
		}
		letterCombinations(digits, 0, "");
		return result;
	}

	public static void main(String[] args) {
		List<String> ret = new LetterProblems().letterCombinations("0129");
		for (String string : ret) {
			System.out.print(string + " ");
		}

	}
}
