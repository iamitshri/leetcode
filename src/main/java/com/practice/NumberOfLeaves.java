package com.practice;

public class NumberOfLeaves {
	public int numberOfLeaves(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;
		int left = numberOfLeaves(root.left);
		int right = numberOfLeaves(root.right);
		return left + right;

	}
}
