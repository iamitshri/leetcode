package com.practice;

public class BestTimeBuySellStockII {
	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */
	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0 || prices.length == 1)
			return 0;
		int min = prices[0];
		int profit = 0;
		int diff = 0;

		for (int i = 1; i < prices.length; i++) {

			diff = prices[i] - min;

			// if you find
			if (diff > 0) {
				// reset min
				min = prices[i];
				profit += diff;
			}

			if (prices[i] < min) {
				min = prices[i];
			}
		}

		return profit;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] trading = new int[] { 1, 2, 4 };
		System.out.print(new BestTimeBuySellStockII().maxProfit(trading));
	}

}
