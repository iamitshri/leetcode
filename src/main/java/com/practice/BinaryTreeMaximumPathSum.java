package com.practice;

public class BinaryTreeMaximumPathSum {
	/**
	 * Given a binary tree, find the maximum path sum.
	 * 
	 * The path may start and end at any node in the tree.
	 * 
	 * For example: Given the below binary tree,
	 * 
	 * 1 / \ 2 3 Return 6.
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {

		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		pathSum(root, max);
		return max[0];
	}

	// -2 1 , -1 2
	public int pathSum(TreeNode root, int[] max) {

		if (root == null)
			return 0;

		int leftsum = pathSum(root.left, max);
		int rightsum = pathSum(root.right, max);

		int current = Math.max(root.val, Math.max(root.val + leftsum, root.val + rightsum));

		max[0] = Math.max(max[0], Math.max(current, leftsum + root.val + rightsum));

		return current;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
