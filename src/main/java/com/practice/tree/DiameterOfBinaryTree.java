package com.practice.tree;

public class DiameterOfBinaryTree {

    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null)
            return 0;

        helper(root);

        return max;
    }

    int helper(TreeNode root){

        if(root==null)
            return 0;

        int l = helper(root.left);
        int r = helper(root.right);
        max = Math.max(max, Math.max(l,Math.max(r,l+r) ));
        return 1 + Math.max(Math.abs(l),Math.abs(r));
    }
}
