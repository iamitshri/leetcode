package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> intArr = new ArrayList<Integer>();
		Stack<TreeNode> treeNodeStk = new Stack<TreeNode>();
		if (root == null)
			return intArr;

		/**
		 * first root then left , right
		 */
		while (root != null) {
			while (root != null) {
				intArr.add(root.val);
				treeNodeStk.push(root);
				root = root.left;
			}

			if (!treeNodeStk.isEmpty()) {

				TreeNode node = treeNodeStk.pop();

				while (node.right == null) {

					if (!treeNodeStk.isEmpty()) {
						node = treeNodeStk.pop();
					} else {
						break;
					}

				}
				root = node.right;
			}
		}
		return intArr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
