package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorder {

	public List<Integer> inorderTraversal(TreeNode root, List<Integer> intArr) {
		if (root == null)
			return intArr;
		else
			intArr = inorderTraversal(root.left, intArr);
		intArr.add(root.val);
		return intArr = inorderTraversal(root.right, intArr);

	}

	/**
	 * This one is iterative solution
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> intArr = new ArrayList<Integer>();
		Stack<TreeNode> treeNodeStk = new Stack<TreeNode>();
		if (root == null)
			return intArr;

		while (root != null) {
			while (root != null) {
				treeNodeStk.add(root);
				root = root.left;
			}

			TreeNode node = null;
			if (!treeNodeStk.isEmpty()) {
				node = treeNodeStk.pop();
			}
			intArr.add(node.val);
			root = node.right;
		}

		return intArr;
		// return inorderTraversal(root, intArr);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
