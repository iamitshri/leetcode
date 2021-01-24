package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LargestValEachRow {
	public static List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode marker = new TreeNode(0);
		q.add(root);
		q.add(marker);

		int max = root.val;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node == marker) {
				result.add(max);
				max = Integer.MIN_VALUE;
				if (!q.isEmpty()) {
					q.add(marker);
				}

			} else {
				if (node.val > max) {
					max = node.val;
				}
			}
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// [1,3,2,5,3,null,9]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		System.out.println(largestValues(root));
	}
}
