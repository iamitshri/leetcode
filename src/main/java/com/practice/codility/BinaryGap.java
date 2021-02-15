package com.practice.codility;

public class BinaryGap {

    public int solution(int N) {
        // 00001001
        int maxGap = 0;
        boolean countStart = false;
        int currentGap = 0;
        while (N > 0) {
            if (!countStart) {
                if ((N & 1) == 1) {
                    countStart = true;
                }
            } else {
                if ((N & 1) == 0) {
                    currentGap++;
                } else {
                    maxGap = Math.max(maxGap, currentGap);
                    currentGap = 0;
                }
            }
            N = N >> 1;
        }
        return maxGap;
    }
}
