package com.practice.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumUniquePairs {

    public static void main(String[] args) {
        //int[] nums = {2, 5, 5, 3, 7, 3, 7};
        int[] nums = {-1, 0, 1, 0, -5, 5};
        int answer = twoSumUniquePairs(nums, 0);
        System.out.println(answer);
    }

    /**
     * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal
     * to target. Return the number of pairs.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1, 1, 2, 45, 46, 46], target = 47 Output: 2 Explanation: 1 + 46 = 47 2 + 45 = 47 Example 2:
     * <p>
     * Input: nums = [1, 1], target = 2 Output: 1 Explanation: 1 + 1 = 2 Example 3:
     * <p>
     * Input: nums = [1, 5, 1, 5], target = 6 Output: 1 Explanation: [1, 5] and [5, 1] are considered the same. Related
     * problems:
     * <p>
     * https://leetcode.com/problems/two-sum https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
     *
     * @return
     */
    static int twoSumUniquePairs(int[] nums, int target) {
        // unique pairs
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int cnt = 0;
        for (int n : nums) {
            if (set.contains(target - n)) {
                set.remove(n);
                set.remove(target - n);
                cnt++;
            }
        }
        return cnt;
    }

    // Java O(nlogn)
    public static int getUniquePairs(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                ans++;
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
        return ans;
    }

    // java O(n)
    public static int getUniquePairsOpti(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int key = map.get(num) * 10 + num;
                if (!seen.contains(key)) {
                    ans++;
                    seen.add(key);
                }
            } else {
                map.put(target - num, num);
            }
        }
        return ans;

    }

    public static int uniquePairs(int[] nums, int target) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for (int num : nums) {
            if (set.contains(target - num) && !seen.contains(num)) {
                count++;
                seen.add(target - num);
                seen.add(num);
            } else if (!set.contains(num)) {
                set.add(num);
            }

        }

        return count;
    }
}
