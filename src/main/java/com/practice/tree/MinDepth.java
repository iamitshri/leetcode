package com.practice.tree;

public class MinDepth {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
