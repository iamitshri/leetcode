package com.practice;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int minDiff= Integer.MAX_VALUE;
        // -1 2 1 -4
        for(int i=0; i < nums.length-2;i++){

            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                // -1 2 1 -4
                // -4 -1 1 2

                int targetDiff = (target-nums[i] - nums[left] - nums[right]);
                if(targetDiff==0){
                    return target-targetDiff;
                }

                if(Math.abs(targetDiff) < Math.abs(minDiff) ||
                       (Math.abs(targetDiff) == Math.abs(minDiff) && targetDiff > minDiff)){
                    minDiff = targetDiff;
                }

                if(targetDiff > 0){

                    left++;
                }else {
                    right--;
                }

            }
        }

        return target-minDiff;
    }

}
