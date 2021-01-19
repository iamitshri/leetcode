package com.practice;

public class ReverseDigits {

    int reverseDigits(int digit){

        int result = 0;
        while(digit!=0) {
            result = result * 10 + digit % 10;
            digit=digit/10; // take off rightmost digit
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseDigits r = new ReverseDigits();
        System.out.println(r.reverseDigits(-102119));
    }
}
