package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetDuplicatesNotAllowed {


    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        Arrays.sort(nums);
        //
        result.add(new ArrayList<>());
        int start=0; int end=0;
        for(int j=0;j<nums.length;j++){
            start=0;
            if(j > 0 && nums[j]==nums[j-1])
                start=end+1;
            end = result.size()-1;
            for(int i=start;i <=end;i++){
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(nums[j]);
                result.add(newList);
            }
        }

        return result;
    }

    void dfs(int nums[],int start, List<Integer> list, List<List<Integer>> result){

        // 1 3 5
        // 1 3 5
        // 1 5
        // 3 5
        // 5
        // []
        // 1
        // 1 3
        // 1 3 5
        // 3
        // 3 5
        // 5

        result.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            if(i > start && nums[i] == nums[i-1] )
                continue;
            list.add(nums[i]);

            dfs(nums,i+1,list,result);

            list.remove(list.size()-1);

        }

    }

}
