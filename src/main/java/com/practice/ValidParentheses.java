package com.practice;

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {

	public static boolean isValid(String s) {
		if (s == null)
			return false;

		LinkedList<Character> stk = new LinkedList<>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(']', '[');
		map.put(')', '(');
		map.put('}', '{');

		char[] arr = s.toCharArray();
		for (char c : arr) {
			if (c == '{' || c == '(' || c == '[') {
				stk.push(c);
			} else {
				if (stk.peek() != map.get(c)) {
					return false;
				} else {
					stk.pop();
				}
			}
		}
		if (!stk.isEmpty())
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}
}
