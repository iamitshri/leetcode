package com.practice;

public class SortedArrayToBST {
	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int start = 0;
		int end = nums.length - 1;
		return createBST(nums, start, end);

	}

	TreeNode createBST(int[] nums, int start, int end) {

		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = createBST(nums, start, mid - 1);
		root.right = createBST(nums, mid + 1, end);

		return root;

	}

}
