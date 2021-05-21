package com.practice.array;

public class RemoveEvenIntegersFromArray {

    public static int[] removeEven(int[] arr) {

        // move pointer only if current element is odd
        int writer = 0;
        for (int reader = 0; reader < arr.length; reader++) {
            if (arr[reader] % 2 != 0) {
                arr[writer++] = arr[reader];
            }
        }
        for (; writer < arr.length; writer++) {
            arr[writer] = 0;
        }
        return arr; // change this and return the correct result array
    }
}
