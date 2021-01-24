package com.practice;

public class PathSum {

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 */

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			return (0 == sum - root.val);
		}

		sum = sum - root.val;
		return (hasPathSum(root.left, sum) || hasPathSum(root.right, sum));

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
