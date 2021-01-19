package com.practice;

public class SwapBits {

    int swap(int n, int i, int j) {

        if ((n >> i & 1) != (n >> j & 1)) {
            n ^= (1 << i | 1 << j);
        }
        return n;
    }

    public static void main(String[] args) {
        SwapBits s = new SwapBits();
        // 11  101
        System.out.println(s.swap(3, 1, 2));
        System.out.println(s.swap(2,0,1));
    }
}
