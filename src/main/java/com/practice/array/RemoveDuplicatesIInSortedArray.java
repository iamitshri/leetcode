package com.practice.array;

public class RemoveDuplicatesIInSortedArray {

    public static int removeDuplicates(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int j = 0;
        // 1 2 3
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[j] != a[i]) {
                a[++j] = a[i];
            }
        }
        return j + 1;
    }

    public static int removeDuplicates1(int[] nums) {
        // validate nums null or empty

        int readPointer = 0;
        int writePointer = 0;
        // 0, 0, 1, 1, 1, 2, 2
        for (readPointer = 1; readPointer < nums.length; readPointer++) {

            if (nums[readPointer] != nums[readPointer - 1]) {
                nums[++writePointer] = nums[readPointer];
            }
        }
        return writePointer + 1;
    }

    public int removeDuplicates3(int[] nums) {

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }


    public static void main(String[] args) {
        int[] i = new int[]{1, 2};
        int n = removeDuplicates(i);
        System.out.println(n);

    }
}
