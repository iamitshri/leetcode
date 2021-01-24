package com.practice;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValid(TreeNode root, int min, int max) {

		if (root == null)
			return true;

		if (root.val < min || root.val > max)
			return false;

		return isValid(root.left, min, root.val - 1) && isValid(root.right, root.val + 1, max);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		// root.left=new TreeNode(6);
		// root.left.right=new TreeNode(7);
		//
		// root.right.left=new TreeNode(3);
		// root.right.left.right=new TreeNode(4);

		ValidateBinarySearchTree b = new ValidateBinarySearchTree();

		System.out.println(b.isValidBST(root));

	}

}
