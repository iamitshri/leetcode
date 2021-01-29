package com.practice.array;

public class DecimalToBinary {

    public static int decimalToBinary(int decimalNum) {
        if (decimalNum == 0) {
            return 0;
        } else {
            return (decimalNum % 2 + 10 * decimalToBinary(decimalNum / 2));
        }
    }
}
