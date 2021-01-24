package com.practice;

public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {

		if (root == null)
			return 0;
		sumnum sum = new sumnum();
		sumNumbers(sum, root, 0);
		return sum.sum;
	}

	class sumnum {
		int sum;
	}

	public void sumNumbers(sumnum sum, TreeNode root, int path) {

		if (root == null)
			return;

		path = 10 * path + root.val;

		if (root.left == null && root.right == null) {
			sum.sum = sum.sum + path;
			return;
		}

		sumNumbers(sum, root.left, path);
		sumNumbers(sum, root.right, path);

		return;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
