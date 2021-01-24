package com.practice;

public class SymmetricTree {

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * For example, this binary tree is symmetric:
	 * 
	 * 1 / \ 2 2 / \ / \ 3 4 4 3 But the following is not: 1 / \ 2 2 \ \ 3 3
	 * Note: Bonus points if you could solve it both recursively and
	 * iteratively.
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode root1, TreeNode root2) {

		if ((root1 == null && root2 == null))
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left))
			return true;
		else
			return false;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
