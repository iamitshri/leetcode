package com.practice;

public class WildCardMatching {

	public boolean isMatch(String s, String p) {

		/*
		 * Got help from this video https://www.youtube.com/watch?v=3ZDZ-N0EPV0
		 */
		if (s == null && p == null) {
			return true;
		}
		int pc = 0;
		char[] arr = p.toCharArray();
		boolean seen = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '*') {
				if (seen) {
					arr[pc++] = arr[i];
					seen = false;
				}
			} else {
				seen = true;
				arr[pc++] = arr[i];
			}
		}

		boolean T[][] = new boolean[s.length() + 1][pc + 1];
		T[0][0] = true;
		if (pc > 0 && arr[0] == '*') {
			T[0][1] = true;
		}
		p = new String(arr);
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					T[i][j] = T[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					T[i][j] = T[i - 1][j] || T[i][j - 1];
				}
			}
		}
		return T[s.length()][pc];
	}

	boolean isMatchRecursive(char[] text, int t, char[] pattern, int p) {
		if (pattern.length == p) {
			return text.length == t;
		}

		if (pattern[p] != '*') {
			if (t < text.length && (pattern[p] == text[t] || pattern[p] == '?')) {
				return isMatchRecursive(text, t + 1, pattern, p + 1);
			} else
				return false;
		} else {
			// go to last *
			while (p < pattern.length - 1 && pattern[p + 1] == '*') {
				p++;
			}
			t--;
			while (t < text.length) {
				if (isMatchRecursive(text, t + 1, pattern, p + 1)) {
					return true;
				}
				t++;
			}

			return false;

		}
	}

	public boolean isMatchTest(String s, String p) {
		if (s == null && p == null) {
			return true;
		}
		if (s == null || p == null) {
			return false;
		}

		return isMatchRecursive(s.toCharArray(), 0, p.toCharArray(), 0);
	}

	public static void main(String[] s) {
		WildCardMatching w = new WildCardMatching();
		System.out.println(w.isMatchRecursive("hccccb".toCharArray(), 0, "h****b".toCharArray(), 0));

	}
}
