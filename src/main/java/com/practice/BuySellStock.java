package com.practice;

public class BuySellStock {
	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 * 
	 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
	 * 
	 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be
	 * larger than buying price) Example 2: Input: [7, 6, 4, 3, 1] Output: 0
	 * 
	 * In this case, no transaction is done, i.e. max profit = 0.
	 * 
	 * @param args
	 */

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxDiff = 0;
		int prevMinStock = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prevMinStock) {
				prevMinStock = prices[i];
			}
			int currentDiff = (prices[i] - prevMinStock);
			if (currentDiff > maxDiff) {
				maxDiff = currentDiff;
			}
		}
		return maxDiff;
	}

	/**
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfitTradeMultipleTimes(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxDiff = 0;
		int prevMinStock = prices[0];
		int totalProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prevMinStock) {
				prevMinStock = prices[i];
			}
			int currentDiff = (prices[i] - prevMinStock);
			if (currentDiff > maxDiff) {
				maxDiff = currentDiff;
				totalProfit += maxDiff;
				maxDiff = 0;
				prevMinStock = prices[i];
			}
		}
		return totalProfit;
	}

	/*
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again). [6,1,3,2,4,7] Output: 5
	 * Expected: 7
	 * 
	 */
	public int maxProfitMax2Transaction(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxDiff = 0;
		int prevMinStock = prices[0];
		int totalProfit = 0;
		int[] last2Profits = new int[2];
		int cnt = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prevMinStock) {
				prevMinStock = prices[i];
			}
			int currentDiff = (prices[i] - prevMinStock);
			if (currentDiff > maxDiff) {
				maxDiff = currentDiff;
				if (maxDiff > last2Profits[0] && maxDiff > last2Profits[1]) {
					if (last2Profits[0] > 0) {
						last2Profits[1] = maxDiff;
					} else {
						last2Profits[0] = maxDiff;
					}

				} else if (maxDiff > last2Profits[0]) {
					last2Profits[0] = maxDiff;

				} else if (maxDiff > last2Profits[1]) {
					last2Profits[1] = maxDiff;

				}

				maxDiff = 0;
				prevMinStock = prices[i];
			}
		}

		for (int j = 0; j < last2Profits.length; j++) {

			totalProfit += last2Profits[j];

		}
		return totalProfit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfitTradeMultipleTimes(new int[] { 2, 4, 7 }));
	}
}
