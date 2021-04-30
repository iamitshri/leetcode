package com.practice.array;

public class DuplicateZeros {

    /**
     * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
     *
     * Note that elements beyond the length of the original array are not written.
     *
     * Do the above modifications to the input array in place, do not return anything from your function.
     *
     * Input: [1,0,2,3,0,4,5,0]
     * Output: null
     * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
     * @param arr
     */
    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            if (arr[i] == 0) {
                int save = arr[i + 1];
                int save2 = 0;
                for (int j = i + 1; j < arr.length - 1; j++) {
                    save2 = arr[j + 1];
                    arr[j + 1] = save;
                    save = save2;
                }
                arr[i + 1] = 0;
                i++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(input);
        for (int n : input) {
            System.out.print(n + " ");
        }
    }

}
