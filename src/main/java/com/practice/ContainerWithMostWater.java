package com.practice;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        // distance between them * min ( lo, hi);
        // low high
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;

        // 1,8,6,2,5,4,8,3,7
        // 0 1 2 3 4 5 6 7 8
        // 8 * 1 = 8
        // 7 * 7 = 49
        //
        while (low < high) {
            int distance = high - low;
            int minHeight = Math.min(height[low], height[high]);
            maxArea = Math.max(maxArea, distance * minHeight);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
