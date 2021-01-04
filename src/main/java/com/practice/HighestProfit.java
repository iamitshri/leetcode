package com.practice;

import java.util.HashMap;
import java.util.Map;

public class HighestProfit {

    public static void main(String[] args) {
        long profit= supplierInventory(2,new long[]{3,5},6);
        System.out.println("profit:"+profit);
    }

    /**
     * https://leetcode.com/discuss/interview-question/804735/amazon-oa-2020-highest-profit
     *
     * @param numSupplier
     * @param inventory
     * @param order
     * @return
     */
    public static long supplierInventory(int numSupplier, long[] inventory, long order) {
        Map<Long, Long> map = new HashMap<>();
        long highest = 0;
        long profit = 0;
        for (int i = 0; i < inventory.length; i++) {
            map.put(inventory[i], map.getOrDefault(inventory[i], 0L) + 1);
            if (highest < inventory[i]) {
                highest = inventory[i];
            }
        }

        while (order > 0 && !map.isEmpty()) {
            long highestFreq = map.get(highest);
            if (order > highestFreq) {
                profit += highestFreq * highest;
                order -= highestFreq;
                map.remove(highest);
                if (map.containsKey(highest - 1)) {
                    map.put(highest - 1, map.get(highest - 1) + highestFreq);
                } else {
                    map.put(highest - 1, highestFreq);
                }

                highest--;
            } else {
                profit += highest * order;
                order = 0;
            }
        }

        return profit;
    }
}
