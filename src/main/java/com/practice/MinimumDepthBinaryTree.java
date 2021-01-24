package com.practice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumDepthBinaryTree {

	/**
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path from the
	 * root node down to the nearest leaf node.
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> cntList = new LinkedList<Integer>();

		queue.offer(root);
		cntList.offer(1);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int cnt = cntList.poll();
			if (node.left != null) {
				cntList.offer(cnt + 1);
				queue.offer(node.left);
			}
			if (node.right != null) {
				cntList.offer(cnt + 1);
				queue.offer(node.right);
			}

			if (node.left == null && node.right == null) {
				return cnt;
			}
		}
		return 0;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
