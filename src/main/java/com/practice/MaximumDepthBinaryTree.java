package com.practice;

public class MaximumDepthBinaryTree {

	/**
	 * @param args
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	/**
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 * 
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p == null && q != null || q == null && p != null)
			return false;

		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
