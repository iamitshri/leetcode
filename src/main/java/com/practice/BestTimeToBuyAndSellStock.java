package com.practice;

public class BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0 || prices.length == 1)
			return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int diff = 0;
		min = prices[0];
		for (int i = 1; i < prices.length; i++) {

			diff = prices[i] - min;

			if (diff > 0 && diff > max) {
				max = diff;
			}
			if (prices[i] < min) {
				min = prices[i];
			}
		}
		if (max == Integer.MIN_VALUE)
			return 0;
		return max;
	}

	// public static void main(String s[]){
	//
	// String name = "hello world!";
	// int[] trading= new int[]{2,1};
	// System.out.println(maxProfit(trading));
	// }
}
