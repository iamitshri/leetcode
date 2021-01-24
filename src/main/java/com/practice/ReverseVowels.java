package com.practice;

import java.util.HashSet;

public class ReverseVowels {

	public String reverseVowelsTwoPtr(String s) {
		HashSet<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		if (s == null || s.length() == 0)
			return s;
		int l = 0;
		int r = s.length() - 1;
		;
		char[] a = s.toCharArray();
		while (l < r) {
			while (l < s.length() && !vowels.contains(a[l])) {
				l++;
			}

			while (r > 0 && !vowels.contains(a[r])) {
				r--;
			}

			if (l < s.length() && l < r) {
				char t = a[l];
				a[l] = a[r];
				a[r] = t;
				l++;
				r--;
			}

		}
		return new String(a);
	}

	public String reverseVowels(String s) {
		HashSet<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		if (s == null || s.length() == 0)
			return s;
		int l = 0;
		int r = 0;
		char[] a = s.toCharArray();
		while (l < s.length()) {
			if (vowels.contains(a[l])) {
				r = l + 1;
				while (r < s.length() && !vowels.contains(a[r])) {
					r++;
				}

				if (r < s.length()) {
					char t = a[l];
					a[l] = a[r];
					a[r] = t;
				}
			}

			l++;
		}
		return new String(a);
	}

	public static void main(String[] args) {
		ReverseVowels r = new ReverseVowels();
		String x = r.reverseVowels("hello");
		System.out.println(x);
	}
}
