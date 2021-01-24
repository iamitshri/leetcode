package com.practice.basics;

import java.util.Arrays;

public class PrimitivesBasics {

    public static void main(String[] args) {


        // primitive sizes
        // int size 32 bits= 4 bytes
        // long size of  64 bits= 8 bytes
        long sizeOfLong=-1l;
        // 1111111111111111111111111111111111111111111111111111111111111111
        System.out.println("Long binary string:"+Long.toBinaryString(sizeOfLong));

        // signedness
        // Integer to binary representation
        int k = -1;
        // int k=-1 is represented as 32 bit "11111111111111111111111111111111"
        // 1 byte is 8 bits, so 32 bits is 4 byte
        System.out.println("Integer to Binary:"+Integer.toBinaryString(k));

        // Left Shift is same as multiplying by 2, It preserves the sign bit
        int p = 10;
        System.out.println("Initial number:"+p);
        int leftShifted=p<<2;
        System.out.println("Left shift:"+leftShifted);

        // left shift with sign
        int ls=-1;
        ls = ls << 1;
        System.out.println("Left shift w sign:"+Integer.toBinaryString(ls));
        System.out.println("Left shift w sign:"+ls);

        // there is no left shift <<< because logical << and <<< are identical

        // Right Shift is same as dividing by 2, it preserves the sign bit
        System.out.println("Initial number:"+leftShifted);
        int rightShifted = leftShifted >>1;
        System.out.println("Right shift:"+rightShifted);

        // 0110 6
        // 0001
        int rightShiftedWithSign = -6>>>2;  // Right shift >>> preserves the sign bit
        System.out.println("Binary Representation:"+Integer.toBinaryString(-6));
        System.out.println("Right shift:"+rightShiftedWithSign);
        System.out.println("Binary Representation:"+Integer.toBinaryString(rightShiftedWithSign));

        // Negation
        int negationExample = 10;
        System.out.println("Negation of "+Integer.toBinaryString(negationExample)+" is "+Integer.toBinaryString(~negationExample));
        //  1010  0101
        System.out.println("Math.max:"+Math.max(10,10.5));
        System.out.println("Math.abs:"+Math.abs(9-99));
        System.out.println("Math.floor:"+Math.floor(99.99));
        System.out.println("Math.ceil:"+Math.ceil(99.01));
        System.out.println("Math.round:"+Math.round(99.49999999));
        System.out.println("Log of N to the base 2: Math.log:"+Math.log(64)/Math.log(2));

        // Get last set bit
        int lastSetBit=4;
        System.out.println(Integer.toBinaryString(lastSetBit)+" Last Set bit:"+Integer.toBinaryString(lastSetBit & (lastSetBit-1)));
        int [] myArray = {1,2,3,4};
       for(int i :  Arrays.copyOfRange(myArray, 2, myArray.length)){
           System.out.println(i);
       }
     }


}
