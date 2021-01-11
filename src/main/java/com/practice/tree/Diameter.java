package com.practice.tree;

public class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {

        helper(root);
        return maxLen;
    }
    int maxLen=0;

    int helper(TreeNode root){
        if(root==null)
            return 0;

        int l = helper(root.left);
        int r = helper(root.right);
        int len = l + r ;
        maxLen = Math.max(maxLen, len);

        return 1 + Math.max(l,r);
    }
}
