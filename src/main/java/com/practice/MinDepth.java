package com.practice;

import java.util.LinkedList;

public class MinDepth {

	public int minDepthRecursiveTimeLimitExceeded(TreeNode root) {

		if (root == null)
			return 0;
		if (root.left == null)
			return 1 + minDepth(root.right);

		if (root.right == null)
			return 1 + minDepth(root.left);

		return 1 + Math.min(minDepth(root.left), minDepth(root.right));

	}

	public int minDepthRecursive(TreeNode root) {
		if (root == null)
			return 0;

		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (left == 0 && right == 0)
			return 1;
		else if (left == 0)
			return 1 + right;
		else if (right == 0)
			return 1 + left;

		return 1 + Math.min(left, right);

	}

	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		int depth = 1;

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode magic = new TreeNode(0);
		q.add(magic);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node == magic) {
				depth++;
				if (!q.isEmpty()) {
					q.add(magic);
				}
				continue;
			}

			if (node.left != null) {
				q.add(node.left);
			}

			if (node.right != null) {
				q.add(node.right);
			}
			// We found the leaf
			if (node.left == null && node.right == null)
				return depth;

		}

		return depth;

	}
}
