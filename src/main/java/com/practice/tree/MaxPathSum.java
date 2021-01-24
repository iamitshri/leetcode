package com.practice.tree;

public class MaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        maxPath(root);
        return max;

    }

    int maxPath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lp = Math.max(maxPath(root.left), 0);
        int rp = Math.max(maxPath(root.right), 0);

        int newPath = root.val + lp + rp;
        max = Math.max(max, newPath);

        return root.val + Math.max(lp, rp);

    }


}
