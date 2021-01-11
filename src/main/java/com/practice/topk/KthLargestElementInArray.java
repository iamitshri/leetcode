package com.practice.topk;

import java.util.concurrent.ThreadLocalRandom;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        // kth larget element using quick sort method
        return findKthMax(nums, 0, nums.length - 1, k);
    }

    int findKthMax(int[] nums, int low, int high, int k) {

        int random = ThreadLocalRandom.current()
                                      .nextInt(low, high + 1);
        swap(nums, high, random);

        int pivot = nums[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (nums[i] <= pivot) {
                swap(nums, pointer++, i);
            }
        }

        swap(nums, pointer, high);
        int cnt = high - pointer + 1;
        if (cnt == k) {
            return nums[pointer];
        }
        if (cnt > k) {
            return findKthMax(nums, pointer + 1, high, k);
        }
        return findKthMax(nums, low, pointer - 1, k - cnt);
    }

    void swap(int[] nums, int i, int j) {
        if (i == j || nums[i] == nums[j]) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
