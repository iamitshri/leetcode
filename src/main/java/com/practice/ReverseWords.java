package com.practice;

public class ReverseWords {
	/**
	 * TODO :Fix this Problem Its not working
	 * 
	 */
	public static String reverseWords(String s) {
		if (s == null || s.isEmpty())
			return "";
		char[] strReversed = s.toCharArray();
		reverseword(strReversed, 0, s.length());
		strReversed = removeExtraSpaces(strReversed).toCharArray();
		for (int i = 0, j = 0; i < strReversed.length; i++) {
			if (strReversed[i] == ' ' || i == strReversed.length - 1) {
				reverseword(strReversed, j, i);
				j = i + 1;
			}
		}
		return new String(strReversed);
	}

	public static String removeExtraSpaces(char[] sb) {
		char aux[] = new char[sb.length];
		boolean firstSpaceSeen = false;
		for (int i = 0, j = 0; i < sb.length; i++) {
			if (sb[i] == ' ' && !firstSpaceSeen) {
				firstSpaceSeen = true;
				aux[j++] = sb[i];
			} else if (Character.isAlphabetic(sb[i])) {
				aux[j++] = sb[i];
				firstSpaceSeen = false;
			}
		}
		return new String(aux).trim();
	}

	public static void reverseword(char[] sb, int start, int end) {

		for (int i = 0; i < (end - start) / 2; i++) {
			char temp = sb[end - i - 1];
			sb[end - 1 - i] = sb[i];
			sb[i] = temp;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("Amit"));
	}
}
