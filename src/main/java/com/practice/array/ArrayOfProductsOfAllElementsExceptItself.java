package com.practice.array;

public class ArrayOfProductsOfAllElementsExceptItself {

    public static int[] findProduct(int arr[]) {
        int[] result = {0};

        int[] aux = new int[arr.length];
        aux[0] = 1;

        for (int i = 1; i < arr.length; i++) {

            aux[i] = arr[i - 1] * aux[i - 1];

        }
        int prev = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int t = arr[i];
            arr[i] = aux[i] * prev;
            prev = prev * t;

        }
        return arr;
    }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray == null || intArray.length < 2) {
            throw new RuntimeException();
        }
        // make an array of the products
        int[] prod = new int[intArray.length];
        prod[0] = 1;
        for (int i = 1; i < intArray.length; i++) {
            prod[i] = prod[i - 1] * intArray[i - 1];
        }

        int last = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            prod[i] = prod[i] * last;
            last = intArray[i] * last;
        }

        return prod;
    }

    public static int[] findProductSimple(int arr[]) {
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int result[] = new int[n];

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }


}
