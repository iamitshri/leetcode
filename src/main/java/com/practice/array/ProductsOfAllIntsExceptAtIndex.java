package com.practice.array;

public class ProductsOfAllIntsExceptAtIndex {

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
}
