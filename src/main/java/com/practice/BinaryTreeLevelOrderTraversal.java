package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);
		// add a row marker
		queue.offer(null);
		List<Integer> tl = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();

			if (temp != null) {
				tl.add(temp.val);
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}

			} else {
				// when you a row marker i.e. null in this case, put back a new
				// null marker
				if (!queue.isEmpty())
					queue.offer(null);

				result.add(tl);
				tl = new ArrayList<Integer>();

			}

		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
