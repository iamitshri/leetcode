package com.practice;

public class Parity {

    public static void main(String[] args) {
        Parity parity = new Parity();
        int num = 2;// 10000
        int p = parity.findParity(num);
        System.out.println("parity: O(n): "+p+"  parity O(num of 1 bits): "+parity.findParityClearLastBit(num));
        //
        // odd number of 1 bits = true
        // even number of bits =0
    }

    private int findParity(int num) {
        int result = 0;
        while (num != 0) {
            result ^= num & 1;
            num >>>= 1;
        }
        return result;
    }

    int findParityClearLastBit(int num){
        int result=0;
        while (num != 0){
            result ^=1;
            num = num & (num-1); // drops the lowest bit
        }
        return result;
    }
}
