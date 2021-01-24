package com.practice.tree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums==null || nums.length==0)
            return null;

        if(nums.length==1)
            return new TreeNode(nums[0]);

        return helper(nums, 0, nums.length-1);

    }

    TreeNode helper(int [] nums, int i, int j){

        if(i > j)
            return null;

        if(i==j)
            return new TreeNode(nums[i]);

        int mid = ( j- i)/2 + i;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, i, mid-1);
        root.right = helper(nums, mid+1, j);
        return root;
    }
}
