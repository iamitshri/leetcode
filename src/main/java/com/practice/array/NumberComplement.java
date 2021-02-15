package com.practice.array;

public class NumberComplement {

    /**
     * https://leetcode.com/problems/number-complement/
     * for example:
     * 100110, its complement is 011001, the sum is 111111. So we only need get the min number large or equal to num, then do substraction
     * @param num
     * @return
     */
    public int findComplement(int num) {

        int n = 0 ;

        while(n < num){
            n = n << 1 | 1 ;
        }
        return n - num;
    }
}
