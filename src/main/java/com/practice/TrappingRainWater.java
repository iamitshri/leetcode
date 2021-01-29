package com.practice;

public class TrappingRainWater {

    public static int trappingRainWater2(int[] elevations) {
        int l = 0;
        int h=elevations.length-1;
        int water=0;
        int lmax=0;
        int rmax=0;
        while(l < h){

            if(elevations[l] < elevations[h]){
                if(elevations[l] > lmax){ lmax=elevations[l];}
                water+=lmax-elevations[l];
                l++;
            }else{
                if(elevations[h] > rmax){ rmax=elevations[h];}
                water+= rmax-elevations[h];
                h--;
            }

        }

        return water;
    }


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

    public static int trappingRainWater(int[] elevations) {
        // WRITE YOUR BRILLIANT CODE HERE
        int n = elevations.length;
        int[] leftWalls = new int[n];
        int[] rightWalls = new int[n];
        int maxLeftWall = 0;
        for (int i = 0; i < n; i++) {
            leftWalls[i] = maxLeftWall;
            maxLeftWall = Math.max(elevations[i], maxLeftWall);
        }
        int maxRightWall = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightWalls[i] = maxRightWall;
            maxRightWall = Math.max(elevations[i], maxRightWall);
        }
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int elevation = elevations[i];
            int lowestWall = Math.min(leftWalls[i], rightWalls[i]);
            if (lowestWall > elevation) {
                totalWater += lowestWall - elevation;
            }
        }
        return totalWater;
    }

}
