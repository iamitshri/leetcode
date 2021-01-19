package com.practice;

import java.util.HashSet;

public class LargestContiguousSubArray {

    public static void main(String[] args) {

        LargestContiguousSubArray lc = new LargestContiguousSubArray();
        int ans = lc.largetContiguousArray(new int[]{14, 12, 11, 20});
        ans=lc.largetContiguousArrayWithDuplicates(new int[] {10, 12, 12, 10, 10, 11, 10});
        System.out.println(ans);
    }

    /**
     * Given an array of distinct integers, find length of the longest subarray which contains numbers that can be
     * arranged in a continuous sequence
     *
     * @param arr
     * @return
     */

    int largetContiguousArray(int[] arr) {

        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (j - i + 1 == (max - min) + 1) {
                    maxLength = Math.max(maxLength, max - min + 1);
                }
            }
        }
        return maxLength;
    }

    /**
     * Given an array of integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.
     * In the previous post, we have discussed a solution that assumes that elements in given array are distinct. Here we discuss a solution that works even if the input array has duplicates
     * @param arr
     * @return
     */
    int largetContiguousArrayWithDuplicates(int[] arr) {

        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int max = arr[i];
            HashSet<Integer> hashSet = new HashSet<Integer>();
            hashSet.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if(hashSet.contains(arr[j]))
                    break;
                hashSet.add(arr[j]);
                if (j - i + 1   == (max - min) + 1) {
                    maxLength = Math.max(maxLength, max - min + 1);
                }
            }
        }
        return maxLength;
    }
}
