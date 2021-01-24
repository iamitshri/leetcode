package com.practice;

public class IsBalanced {
	public boolean isBalanced(TreeNode root) {
		if (-1 == checkHeight(root))
			return false;
		else
			return true;

	}

	int checkHeight(TreeNode root) {
		if (root == null)
			return 0;

		int left = checkHeight(root.left);
		if (left == -1)
			return -1;

		int right = checkHeight(root.right);
		if (right == -1)
			return -1;

		if (Math.abs(left - right) > 1)
			return -1;
		else
			return 1 + Math.max(left, right);

	}
}
