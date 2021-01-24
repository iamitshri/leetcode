package com.practice;

import java.util.LinkedList;

public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		TreeNode pre = null;
		LinkedList<TreeNode> stk = new LinkedList<>();

		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			root = stk.pop();
			if (pre != null && root.val <= pre.val)
				return false;

			pre = root;

			root = root.right;

		}

		return true;

	}

	boolean isBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val < min || root.val >= max)
			return false;

		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);

	}
}
