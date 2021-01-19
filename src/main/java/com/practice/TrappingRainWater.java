package com.practice;

public class TrappingRainWater {

    public int trap(int[] a) {

        if (a == null || a.length == 0) {
            return 0;
        }

        int i = 0;
        int j = a.length - 1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int ans = 0;
        while (i <= j) {

            if (a[i] <= a[j]) {

                if (a[i] > leftMax) {
                    leftMax = a[i];
                } else {
                    ans += leftMax - a[i];
                }
                i++;
            } else if (a[i] > a[j]) {
                if (a[j] > rightMax) {
                    rightMax = a[j];
                } else {
                    ans += rightMax - a[j];

                }
                j--;
            }

        }
        return ans;
    }

}
