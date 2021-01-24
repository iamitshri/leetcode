package com.practice;

import java.util.LinkedList;

public class NumbersToString {
	String[] unitPlace = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen" };
	String[] tenth = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty" };
	String[] hundreds = { "", "thousand", "million", "billion" };

	String numberToString(int n) {
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		LinkedList<String> lst = new LinkedList<>();
		while (n > 0) {
			if (n % 1000 > 0) {
				String s = LessThanThousandToString(n % 1000) + "" + hundreds[cnt] + " ";
				lst.addFirst(s);
			}
			cnt += 1;
			n = n / 1000;
		}
		while (!lst.isEmpty()) {
			sb.append(lst.pop());
		}
		return sb.toString();
	}

	String LessThanThousandToString(int n) {

		StringBuilder sb = new StringBuilder();
		if (n <= 999) {
			int t = n;
			t = t / 100;
			if (t > 0) {
				sb.append(unitPlace[t]);
				sb.append(" hundred ");
			}
			n = n % 100;
		}
		if (n > 0) {

			if (n % 10 == 0) {
				n = n / 10;
				sb.append(" " + tenth[n] + " ");
			} else if (n < 20) {
				sb.append(" " + unitPlace[n] + " ");
			} else {
				sb.append(" " + tenth[n / 10] + " ");
				sb.append(" " + unitPlace[n % 10] + " ");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		NumbersToString ns = new NumbersToString();
		String s = ns.numberToString(100001);
		System.out.println(s);
	}
}
