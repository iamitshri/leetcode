package com.practice;

import java.util.LinkedList;
import java.util.Scanner;

public class NaiveReversePolishNotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] arr = input.split(" ");
		LinkedList<String> stk = new LinkedList<String>();
		// 5 3 * 2 +
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				arr[i] = arr[i].trim();
				if (arr[i].chars().allMatch(Character::isDigit)) {
					stk.push(arr[i]);
				} else {
					int result = 0;
					int p1 = 0;
					int p2 = 0;
					if (!stk.isEmpty()) {
						String op1 = stk.pop();
						String op2 = "";
						if (!stk.isEmpty()) {
							op2 = stk.pop();
						}
						// I could use try parse
						try {
							p1 = Integer.parseInt(op1);
						} catch (Exception e) {

						}
						try {
							p2 = Integer.parseInt(op2);
						} catch (Exception e) {

						}
					}
					if (arr[i].equalsIgnoreCase("+")) {
						result = p1 + p2;
					} else if (arr[i].equalsIgnoreCase("-")) {
						result = p1 - p2;
					} else if (arr[i].equalsIgnoreCase("*")) {
						result = p1 * p2;
					} else if (arr[i].equalsIgnoreCase("/")) {
						result = p1 / p2;
					}

					stk.push(String.valueOf(result));
				}
			}
		}
		in.close();
		if (!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
	}

}
