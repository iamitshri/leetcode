package com.practice.codility;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        int ret = 0;
        for (int a : A) {
            ret ^= a;
        }
        return ret;
    }
}
