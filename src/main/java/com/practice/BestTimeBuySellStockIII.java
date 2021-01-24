package com.practice;

/*this solution is not working*/
public class BestTimeBuySellStockIII {
	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 */

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0 || prices.length == 1)
			return 0;
		int min = prices[0];
		int[] profit = new int[prices.length];
		int diff = 0;
		int cnt = 0;
		for (int i = 1; i < prices.length; i++) {

			diff = prices[i] - min;
			// if you find
			if (diff > 0) {

				// reset min
				min = prices[i];
				profit[i] = diff;
			}

			if (prices[i] < min) {
				min = prices[i];
			}
		}
		int max = 0, oldMax = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < profit.length - 1; j++) {
				if (profit[j] > profit[j + 1]) {
					int temp = profit[j];
					profit[j] = profit[j + 1];
					profit[j + 1] = temp;
				}
			}

		}
		int n = profit.length - 1;
		max = profit[n];
		oldMax = profit[n - 1];
		return max + oldMax;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] trading = new int[] { 6, 1, 3, 2, 6, 1, 3, 2, 4, 74, 7 };
		System.out.print(new BestTimeBuySellStockIII().maxProfit(trading));
	}

}
