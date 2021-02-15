package com.practice.dfs;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    /*
    https://leetcode.com/problems/target-sum/
     */
    public int findTargetSumWays(int[] nums, int S) {
        findTarget(nums, 0, 0, S);
        return numWays;

    }

    int numWays = 0;

    void findTarget(int[] nums, int start, int sum, int target) {

        if (start >= nums.length) {
            if (sum == target) {
                numWays++;
            }
            return;
        }
        findTarget(nums, start + 1, sum + nums[start], target);
        findTarget(nums, start + 1, sum - nums[start], target);
    }


    public int findTargetSumWaysMemoized(int[] nums, int S) {
        Map<String, Integer> memo = new HashMap<>();
        return findTarget(nums, 0, 0, S, memo);
    }


    int findTarget(int[] nums, int start, int sum, int target, Map<String, Integer> memo) {

        String key = start + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (start >= nums.length) {
            return (sum == target) ? 1 : 0;
        }
        int result = findTarget(nums, start + 1, sum + nums[start], target, memo) + findTarget(nums, start + 1,
                                                                                               sum - nums[start],
                                                                                               target, memo);
        memo.put(key, result);
        return memo.get(key);
    }
}
