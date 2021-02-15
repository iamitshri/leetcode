package com.practice.array;

public class ShortestUnsortedContinuousSubarray {

    /**
     * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarrayEasyToUnderStand(int[] nums) {

        int begin=0;
        int end=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        //iterate from end of array
        //find the last element which is bigger than the last seen min from
        //its right side and mark it as begin
        for(int i=nums.length-1;i>=0;i--){
            min = Math.min(min, nums[i]);
            if(nums[i] > min)
                begin=i;
        }

        //iterate from beginning of array
        //find the last element which is smaller than the last seen max from
        //its left side and mark it as end
        for(int i=0; i < nums.length;i++){
            max = Math.max(max,nums[i]);
            if(nums[i] < max){
                end = i;
            }
        }
        if(end==begin)
            return 0;
        return end-begin+1;
    }

    public int findUnsortedSubarray(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 2 6 4 8 10 9 15
        // 2 1
        // find the 1st index where item is not in sorted fashion
        while (low < nums.length - 1 && nums[low] <= nums[low + 1]) {
            low++;
        }

        if (low == nums.length - 1) {
            return 0;
        }

        while (high > 0 && nums[high] >= nums[high - 1]) {
            high--;
        }

        for (int i = low; i <= high; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        while (low > 0 && nums[low - 1] > min) {
            low--;
        }

        while (high < nums.length - 1 && nums[high + 1] < max) {
            high++;
        }

        return high - low + 1;
    }
}
