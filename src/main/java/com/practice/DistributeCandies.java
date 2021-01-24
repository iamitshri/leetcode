package com.practice;

import java.util.HashMap;

public class DistributeCandies {

	public int distributeCandies(int[] candies) {
		if (candies == null || candies.length == 0)
			return 0;
		int len = candies.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int candie : candies) {
			map.put(candie, map.get(candie) != null ? map.get(candie) + 1 : 1);
		}
		int maxDiffCandy = map.keySet().size();
		if (maxDiffCandy <= len / 2) {
			return maxDiffCandy;
		} else {
			return (len / 2);
		}

	}

	public static void main(String[] args) {
		DistributeCandies d = new DistributeCandies();
		System.out.println(d.distributeCandies(new int[] { 1, 2, 33, 4, 4, 4 }));
	}

}
