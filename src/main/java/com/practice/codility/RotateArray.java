package com.practice.codility;

public class RotateArray {

    public int[] solution(int[] A, int K) {
        K = K % A.length;
        reverse(A, 0, A.length - 1);
        reverse(A, 0, K - 1);
        reverse(A, K, A.length - 1);
        return A;
    }

    void reverse(int[] a, int start, int end) {
        while (start < end) {
            int t = a[start];
            a[start] = a[end];
            a[end] = t;
            start++;
            end--;
        }
    }

    public int[] cyclicRotateArray(int[] A, int K) {
        // write your code in Java SE 8

        // Using the concept of "mod" (to make it cyclic)

        int[] new_array = new int[A.length]; // a new array

        for (int i = 0; i < A.length; i++) {
            int new_position = (i + K) % A.length; // using "mod" to do Cyclic Rotation
            new_array[new_position] = A[i]; // put A[i] to the new position
        }

        return new_array; // return new array
    }

    /**
     * https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1 Given an unsorted array arr[]
     * of size N, rotate it by D elements in the counter-clockwise direction. Input: N = 5, D = 2 arr[] = {1,2,3,4,5}
     * Output: 3 4 5 1 2 Explanation: 1 2 3 4 5  when rotated by 2 elements, it becomes 3 4 5 1 2.
     *
     * @param arr
     * @param d
     * @param n
     */
    void rotateArr(int arr[], int d, int n) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, arr.length - d - 1);
        reverse(arr, arr.length - d, arr.length - 1);
    }


}
