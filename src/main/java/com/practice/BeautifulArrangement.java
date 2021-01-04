package com.practice;

public class BeautifulArrangement {

    int ans = 0;

    public int countArrangement(int n) {

        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        dfs(nums, 1);

        return ans;
    }

    void dfs(int[] nums, int n) {
        if (n == nums.length) {
            ans++;
            return;
        }

        for (int i = n; i < nums.length; i++) {
            if (nums[i] % n == 0 || n % nums[i] == 0) {
                swap(nums, n, i);
                dfs(nums, n + 1);
                swap(nums, n, i);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
