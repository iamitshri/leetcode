package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

	public static void main(String s[]) {

		// permute("abc");
		permutation("abc");
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer i : nums)
			list.add(i);
		permuteHelper(list, new ArrayList<Integer>(), new ArrayList<Integer>(list), result);
		return result;
	}

	static void permuteHelper(ArrayList<Integer> nums, ArrayList<Integer> prefix, ArrayList<Integer> leftover,
			List<List<Integer>> result) {
		if (leftover.size() == 0) {
			result.add(new ArrayList<Integer>(prefix));
			return;
		}
		for (int i = 0; i < leftover.size(); i++) {
			List<Integer> l1 = leftover.subList(0, i);
			List<Integer> l2 = leftover.subList(i + 1, leftover.size());
			prefix.add(leftover.get(i));
			ArrayList<Integer> lo = new ArrayList<Integer>(l1);
			lo.addAll(l2);
			permuteHelper(nums, prefix, lo, result);
			prefix.remove(leftover.get(i));
		}

	}

	static void printArrayList(List<List<Integer>> printThis) {
		for (List<Integer> p : printThis) {
			for (Integer i : p) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static void permute(String string) {
		if (string == null) {
			System.out.println("No Permutations for empty or null String");
		}
		string = string.trim();
		if (string.equalsIgnoreCase("")) {
			System.out.println("No Permutations for empty or null String");
			return;
		}
		HashSet<Character> used = new HashSet<>();
		permuteHelper(new StringBuilder(), string, used);
	}

	private static void permuteHelper(StringBuilder sb, String string, HashSet<Character> used) {
		if (sb.length() == string.length()) {
			System.out.println(sb);
			return;
		}
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			if (used.contains(currentChar)) {
				continue;
			}
			sb.append(currentChar);
			used.add(currentChar);
			permuteHelper(sb, string, used);
			used.remove(currentChar);
			sb.setLength(sb.length() - 1 > 0 ? sb.length() - 1 : sb.length());
		}

	}

	public static void permutation(String str) {
		/*
		 * Send empty string attach character by plucking it out of the original
		 * string
		 * 
		 * 
		 */
		perm(str, "");
	}

	private static void perm(String str, String inProcessString) {
		if (str.length() == 0) {
			System.out.println(inProcessString);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			perm(str.substring(0, i) + str.substring(i + 1), inProcessString + str.charAt(i));
		}

	}

}
