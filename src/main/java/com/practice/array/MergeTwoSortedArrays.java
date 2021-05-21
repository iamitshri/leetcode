package com.practice.array;

public class MergeTwoSortedArrays {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[index++] = arr1[i++];
            } else {
                result[index++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[index++] = arr2[j++];
        }
        return result; // make a new resultant array and return your results in that
    }
}
