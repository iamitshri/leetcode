package com.practice;

public class DistanceBetweenNodes {

	static int getNodeDistance(TreeNode root, int n1, int n2) {
		if (root == null)
			return 0;
		// if root is n1 or n2
		// n1 is left on left side or n2 is on left side
		// n2 is right or n1

		int left = getNodeDistance(root.left, n1, n2);

		int right = getNodeDistance(root.right, n1, n2);

		if (root.val == n1 || root.val == n2) {
			int already = left != 0 ? left : right;
			return already;
		}
		// not found on both side
		if (left == 0 && right == 0)
			return 0;

		return left + right;
	}

	public static void main(String[] args) {
		TreeNode root = CreateBST.createBST(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		System.out.println(getNodeDistance(root, 3, 8));
	}
}
