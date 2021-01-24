package com.practice;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each
	 * path's sum equals the given sum.
	 * 
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> pathArr = new ArrayList<Integer>();

		result = pathSum(root, sum, pathArr, result);

		return result;
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum, ArrayList<Integer> pathArr, List<List<Integer>> result) {

		if (root == null)
			return result;

		if (root.left == null && root.right == null) {
			if (0 == sum - root.val) {

				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.addAll(pathArr);
				arr.add(root.val);
				result.add(arr);
				return result;
			}

		}

		pathArr.add(root.val);
		sum = sum - root.val;

		result = pathSum(root.left, sum, pathArr, result);
		result = pathSum(root.right, sum, pathArr, result);

		if (pathArr.size() != 0)
			pathArr.remove(pathArr.size() - 1);

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
