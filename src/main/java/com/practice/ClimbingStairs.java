package com.practice;

import java.util.HashMap;

public class ClimbingStairs {

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int climbStairs(int n) {

		if (n == 1)
			return 1;

		if (n == 2)
			return 2;

		if (map.containsKey(n))
			return map.get(n);
		else {
			map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
		}

		return map.get(n);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
