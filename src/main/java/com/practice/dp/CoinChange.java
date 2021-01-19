package com.practice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    Map<Integer,Integer> map = new HashMap<>();
    public int coinChangeRecursive(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        if(map.get(amount)==null){
            int minNum=amount+1;
            for(int coin : coins){
                if(amount >= coin){
                    int num = coinChangeRecursive(coins,amount-coin)+1;
                    if(num > 0 && num < minNum){
                        minNum=num;
                    }
                }
            }
            map.put(amount,minNum > amount ? -1:minNum);
        }
        return map.get(amount);
    }
}
