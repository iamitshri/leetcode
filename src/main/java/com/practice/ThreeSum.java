package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  result = new ArrayList<>();
        if(nums.length==0)
            return result;

        // sort + two pointer
        Arrays.sort(nums);
        for(int i=0; i < nums.length-2;i++){

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            searchPair(nums,-nums[i],i+1,result);
        }
        return result;
    }

    void searchPair(int [] nums, int target, int left, List<List<Integer>> result){

        int right = nums.length-1;

        while(left < right){

            int currentSum = nums[left] + nums[right];
            if(currentSum==target){
                result.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;

                while(left < right && nums[left]==nums[left-1])
                    left++;

                while(left < right && nums[right]==nums[right+1])
                    right--;
            }else if (currentSum > target){
                right--;
            }else{
                left++;
            }
        }
    }
}
