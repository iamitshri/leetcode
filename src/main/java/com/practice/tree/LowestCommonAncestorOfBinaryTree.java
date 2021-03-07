package com.practice.tree;

public class LowestCommonAncestorOfBinaryTree {

    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
     * Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if ((left == p || left == q) && (right == p || right == q)) {
            return root;
        }

        if (left == p || left == q) {
            return left;
        }

        if (right == p || right == q) {
            return right;
        }

        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        Result r = helper(root, p, q);
        return r.node;
    }

    public class Result {

        int cnt;
        TreeNode node;
        boolean found;

        Result(int c, TreeNode n, boolean f) {
            cnt = c;
            node = n;
            found = f;
        }
    }

    Result helper(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return new Result(0, null, false);
        }

        Result l = helper(root.left, p, q);
        if (l.found) {
            return l;
        }

        Result r = helper(root.right, p, q);
        if (r.found) {
            return r;
        }

        int total = l.cnt + r.cnt + (root == p ? 1 : 0) + (root == q ? 1 : 0);
        return new Result(total, (total == 2 ? root : null), (total == 2 ? true : false));
    }
}
