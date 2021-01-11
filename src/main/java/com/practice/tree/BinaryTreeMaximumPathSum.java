package com.practice.tree;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        maxSum = Math.max(maxSum, l + r + root.val);
        maxSum = Math.max(maxSum, l + root.val);
        maxSum = Math.max(maxSum, r + root.val);
        maxSum = Math.max(maxSum, root.val);
        return Math.max(root.val, root.val + Math.max(l, r));
    }
}
