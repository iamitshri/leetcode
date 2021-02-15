package com.practice.codility;

public class FrogJmp {

    public int solution(int X, int Y, int D) {
        return (int) Math.ceil((Y - X) / (1.0 * D));
    }
}
