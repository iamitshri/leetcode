package com.practice;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        int rot = l;
        l = 0;
        h = nums.length - 1;

        while (l <= h) {
            int m = (l + h) / 2;
            int rm = (m + rot) % nums.length;
            if (nums[rm] == target) {
                return rm;
            }
            if (target > nums[rm]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }
}
