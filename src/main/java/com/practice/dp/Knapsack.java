package com.practice.dp;

public class Knapsack {

    // profits[]
    // weights[]
    // capacity

    /**
     * Time complexity: O(2 ^ N) Space Complexity= O(N)
     *
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    static int knapsackMaxProfit(int[] profits, int[] weights, int capacity) {
        int maxProfit = helper(0, profits, weights, capacity);
        return maxProfit;
    }

    static int helper(int currentIndex, int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        int profit1 = 0;
        int profit2 = 0;
        // include
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex]
                          + helper(currentIndex + 1, profits, weights, capacity - weights[currentIndex]);
        }

        // exclude
        profit2 = helper(currentIndex + 1, profits, weights, capacity);
        return Math.max(profit1, profit2);
    }

    /***
     * Time complexity: O( Num items * Capacity)
     *
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    static int knapsackMaxProfitWithMemoization(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        int maxProfit = helper(0, profits, weights, capacity);
        return maxProfit;
    }

    static int helper(Integer[][] dp, int currentIndex, int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        if (dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }
        int profit1 = 0;
        int profit2 = 0;
        // include
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex]
                          + helper(dp, currentIndex + 1, profits, weights, capacity - weights[currentIndex]);
        }
        // exclude
        profit2 = helper(dp, currentIndex + 1, profits, weights, capacity);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }

    /**
     * dp[w][c] profit for weight w and capacity c Time complexity: O( Num items * Capacity)
     *
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    static int KnapsackBottomUpAndPrintSelectedItems(int[] profits, int[] weights, int capacity) {

        int[][] dp = new int[profits.length][capacity + 1];

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int p1 = 0;
                int p2 = 0;
                if (weights[i] <= c) {
                    p1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                p2 = dp[i - 1][c];
                dp[i][c] = Math.max(p1, p2);
            }
        }
        printSelectedItems(dp, profits, weights, capacity);
        return dp[profits.length - 1][capacity];
    }

    static void printSelectedItems(int[][] dp, int[] profits, int[] weights, int capacity) {

        int total = dp[profits.length - 1][capacity];
        for (int i = profits.length - 1; i > 0; i--) {
            if (total != dp[i - 1][capacity]) {
                System.out.println("Selected item:" + i + " with weight:" + weights[i]);
                total -= profits[i];
                capacity -= weights[i];
            }
        }
        if (total != 0) {
            System.out.print(" " + weights[0]);
        }
        System.out.println("");
    }

    /**
     * This solution has a space complexity of O(2*C) = O(C)O(2∗C)=O(C), where ‘C’ is the knapsack’s maximum capacity.
     *
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    static int KnapsackBottomUpOptimized(int[] profits, int[] weights, int capacity) {

        int[][] dp = new int[2][capacity + 1];

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = dp[1][c] = profits[0];
            }
        }

        for (int i = 0; i < 2; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int p1 = 0;
                int p2 = 0;
                if (weights[i] <= c) {
                    p1 = profits[i] + dp[(i - 1) % 2][c - weights[i]];
                }
                p2 = dp[(i - 1) % 2][c];
                dp[i % 2][c] = Math.max(p1, p2);
            }
        }

        return dp[(profits.length - 1) % 2][capacity];
    }

    static int knapsackUsingSingleArray(int[] profits, int[] weights, int capacity) {
        // basic checks

        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) {
            return 0;
        }

        int[] dp = new int[capacity + 1];
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[c] = profits[0];
            }
        }
        for (int i = 1; i < profits.length; i++) {
            for (int c = capacity; c >= 0; c--) {
                int p1 = 0;
                int p2 = 0;
                if (weights[i] <= c) {
                    p1 = profits[i] + dp[c - weights[i]];
                }
                p2 = dp[c];
                dp[c] = Math.max(p1, p2);
            }
        }
        return dp[capacity];

    }

    public static void main(String[] args) {

        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;

        int p = knapsackMaxProfit(profits, weights, capacity);
        System.out.println("1. Profit:" + p);

        p = knapsackMaxProfitWithMemoization(profits, weights, capacity);
        System.out.println("2. Profit:" + p);

        p = KnapsackBottomUpAndPrintSelectedItems(profits, weights, capacity);
        System.out.println("3. Profit:" + p);

        p = KnapsackBottomUpOptimized(profits, weights, capacity);
        System.out.println("4. Profit:" + p);

        p = knapsackUsingSingleArray(profits, weights, capacity);
        System.out.println("5. Profit:" + p);
    }
}
