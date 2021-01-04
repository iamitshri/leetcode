package com.practice;


//Definition for a binary tree node.
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class IsSubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return false;
        }

        if (isTreeSame(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    boolean isTreeSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isTreeSame(t1.left, t2.left) && isTreeSame(t1.right, t2.right);
    }
}