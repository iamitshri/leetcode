package com.practice;

public class BuyStock {

	public int maxProfit(int[] prices) {
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

	static void printArr(int[][] sp, int[] prices) {
		for (int i = 0; i <= prices.length; i++) {
			for (int j = 0; j <= prices.length; j++) {
				System.out.print(sp[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param j
	 * @param sp
	 * @return
	 */
	static int getMaxProfit(int j, int sp[][]) {
		int max = 0;
		if (j >= sp.length) {
			System.out.println("j greater than array length");
			return 0;
		}
		for (int k = j + 1; k < sp.length; k++) {
			for (int l = j + 1; l < sp.length; l++) {
				if (sp[k][l] > max) {
					max = sp[k][l];
				}
			}
		}
		return max;
	}

	static int getMaxProfitOnADay(int j, int sp[][]) {
		int max = 0;
		if (j >= sp.length) {
			System.out.println("j greater than array length");
			return 0;
		}
		for (int l = 1; l < sp.length; l++) {
			if (sp[l][j] > max) {
				max = sp[l][j];
			}

		}
		return max;
	}

	public static int maxProfitMax2Txn(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}
		int sp[][] = new int[prices.length + 1][prices.length + 1];
		for (int i = 1; i <= prices.length; i++) {
			sp[0][i] = prices[i - 1];
			sp[i][0] = prices[i - 1];
		}

		for (int i = 1; i <= prices.length; i++) {
			for (int j = i; j <= prices.length; j++) {
				sp[i][j] = sp[0][j] - sp[i][0];
			}
		}
		int localMax = 0;
		int otherMax = 0;
		int maxTxnProfit = 0;
		for (int j = 1; j < sp.length; j++) {
			localMax = getMaxProfitOnADay(j, sp);
			otherMax = getMaxProfit(j, sp);
			if ((localMax + otherMax) > maxTxnProfit) {
				maxTxnProfit = localMax + otherMax;
			}
		}

		return maxTxnProfit;

	}

	public static void main(String[] args) {
		System.out.println(maxProfitMax2Txn(new int[] { 6, 1, 3, 2, 4, 7 }));
	}

}
