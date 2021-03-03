package com.practice.array;

public class MissingNumberInArray {

    int MissingNumber(int arr[], int n) {
        // 2 3 4
        // 4 2 3
        int i = 0;
        while (i < arr.length) {
            if (arr[i] < n && arr[i] != (i + 1)) {
                swap(arr, arr[i] - 1, i);
            } else {
                i++;
            }
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return arr.length + 1;
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    int MissingNumberUsingFormula(int array[], int n) {
        int i, total;
        total = (n + 1) * (n) / 2;
        for (i = 0; i < n-1; i++)
            total -= array[i];
        return total;
    }

}
