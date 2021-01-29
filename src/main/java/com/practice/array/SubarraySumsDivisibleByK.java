package com.practice.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] a, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            int n = sum % k;
            int compliment = (k - n) % k;
            cnt += map.getOrDefault(compliment, 0);
            map.put(compliment, map.getOrDefault(compliment, 0) + 1);
        }
        return cnt;
    }

    public static int subarraySumDivisible(int[] nums, int k) {
        HashMap<Integer, Integer> remainders = new HashMap<>();
        remainders.put(0, 1);
        int curSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            curSum += num;
            int remainder = curSum % k;
            int compliment = (k - remainder) % k;
            if (remainders.containsKey(compliment)) {
                count += remainders.get(compliment);
            }
            if (remainders.containsKey(compliment)) {
                remainders.replace(compliment, remainders.get(compliment) + 1);
            } else {
                remainders.put(compliment, 1);
            }
        }
        return count;
    }
}
