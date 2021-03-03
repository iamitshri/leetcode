package com.practice;

public class MaxSubArrayOutputElementInRange {

    public static void main(String[] s) {
        // int[] res = maxSum(new int[] { -1, 2, -4, 5, -3, 1, 2, 3, -1, 3 });
        int[] res = maxSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("printing result");
        for (int r : res) {
            System.out.println(r);
        }
    }

    public static int[] maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int rangeEnd = 0;
        int rangeStart = 0;
        int maxSum = arr[0];
        int maxSoFar = arr[0];
        int start = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > (maxSoFar + arr[i])) {
                start = i;
                maxSoFar = arr[i];
            } else {
                maxSoFar = maxSoFar + arr[i];
            }
            if (maxSoFar > maxSum) {
                maxSum = maxSoFar;
                rangeStart = start;
                rangeEnd = i;
            }
        }
        int l = (rangeEnd - rangeStart) + 1;
        int[] result = new int[l];
        System.arraycopy(arr, rangeStart, result, 0, l);
        return result;
    }


}
