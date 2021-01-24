package com.practice;

public class TreeOperations {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (q == null) {
			return false;
		}
		if (p == null) {
			return false;
		}

		return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
