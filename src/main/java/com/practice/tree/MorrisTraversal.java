package com.practice.tree;

public class MorrisTraversal {

    void morrisTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.left == null) {
                System.out.println(root.val);
                root = root.right;
            } else {
                TreeNode predecessor = findPredecessor(root);
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    predecessor.right = null;
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }


    }

    private TreeNode findPredecessor(TreeNode root) {
        TreeNode ip = root.left;
        while (ip != null && ip.right != null && ip.right != root) {
            ip = ip.right;
        }
        return ip;
    }

    public static void main(String[] args) {
        var left = new TreeNode(10, new TreeNode(1), new TreeNode(15));
        var right = new TreeNode(30, new TreeNode(25, new TreeNode(22), null), new TreeNode(35));
        TreeNode root = new TreeNode(30, left, new TreeNode(40));
        MorrisTraversal m = new MorrisTraversal();
        m.morrisTraversal(root);
    }
}
