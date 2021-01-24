package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	HashMap<String, Boolean> strProcessed = new HashMap<String, Boolean>();

	/**
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 *
	 */
	public boolean wordBreak(String s, Set<String> dict) {

		if (dict == null || dict.size() == 0 || s == null || s.length() == 0)
			return false;

		if (strProcessed.containsKey(s))
			return strProcessed.get(s);

		if (dict.contains(s)) {
			strProcessed.put(s, true);
			return true;
		}
		for (int i = 1; i < s.length(); i++) {

			if (wordBreak(new String(s.substring(i, s.length())), dict)
					&& wordBreak(new String(s.substring(0, i)), dict)) {
				strProcessed.put(s, true);
				return true;
			}
		}
		strProcessed.put(s, false);
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak w = new WordBreak();
		Set<String> dict = new HashSet<String>();
		dict.add("aa");
		dict.add("bb");
		System.out.println("" + w.wordBreak("aabb", dict));

	}

}
