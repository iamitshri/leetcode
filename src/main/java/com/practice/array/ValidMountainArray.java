package com.practice.array;

public class ValidMountainArray {

    /**
     * Given an array of integers arr, return true if and only if it is a valid mountain array.
     * <p>
     * Recall that arr is a mountain array if and only if:
     * <p>
     * arr.length >= 3 There exists some i with 0 < i < arr.length - 1 such that: arr[0] < arr[1] < ... < arr[i - 1] <
     * arr[i] arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {

        int N = arr.length;
        int i = 0;
        while (i + 1 < N && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == N - 1) {
            return false;
        }

        while (i + 1 < N && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == N - 1;
    }
}
