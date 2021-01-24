package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {

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
				node = treeNodeStk.peek().right;
				if (node != null) {
					root = node;
				} else {

					node = treeNodeStk.pop();
					intArr.add(node.val);
					while (!treeNodeStk.isEmpty()
							&& (node == treeNodeStk.peek().right || treeNodeStk.peek().right == null)) {
						node = treeNodeStk.pop();
						intArr.add(node.val);
					}
					if (!treeNodeStk.isEmpty())
						root = treeNodeStk.peek().right;

					if (treeNodeStk.isEmpty()) {
						break;
					}

				}
			} else {
				break;
			}

		}

		return intArr;
		// return inorderTraversal(root, intArr);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left = new TreeNode(6);
		root.left.right = new TreeNode(7);

		root.right.left = new TreeNode(3);
		root.right.left.right = new TreeNode(4);

		BinaryTreePostorderTraversal b = new BinaryTreePostorderTraversal();
		for (Integer integer : b.postorderTraversal(root)) {
			System.out.println(integer);
		}

	}

}
