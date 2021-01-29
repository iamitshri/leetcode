package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        // BFS approach
        // In each step # of subsets are doubling 2^N
        // And we construct new subset from original so N * 2 ^ N
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(n);
                result.add(newList);
            }
        }

        return result;
    }


    public List<List<Integer>> subsetsDfs(int[] nums) {

        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums,0,lst,result);

        return result;
    }
    /// [] , [1], [1,2],[1,2,3],[1,3],[2],[2,3],[3]
    void dfs(int []nums,int start, List<Integer> lst, List<List<Integer>> result){

        result.add(new ArrayList<>(lst));

        for(int i=start; i < nums.length;i++){
            lst.add(nums[i]);
            dfs(nums,i+1,lst,result);
            lst.remove(lst.size()-1);
        }

    }
}
