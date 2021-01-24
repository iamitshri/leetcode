package com.practice;

public class ReverseStrings {

	public String reverseString(String s) {
		if (s == null || s.length() == 0)
			return s;
		int i = 0;
		int j = s.length() - 1;
		char[] str = s.toCharArray();
		while (i < j) {
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i++;
			j--;
		}
		return new String(str);

	}

}
