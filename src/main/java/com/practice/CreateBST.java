package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateBST {

	static TreeNode createBST(int[] arr) {
		TreeNode root = null;
		for (int i = 0; i < arr.length; i++) {
			root = addNode(arr[i], root);
		}
		return root;
	}

	static TreeNode addNode(int item, TreeNode root) {
		if (root == null) {
			root = new TreeNode(item);
		} else if (item > root.val) {
			root.right = addNode(item, root.right);
		} else {
			root.left = addNode(item, root.left);
		}
		return root;
	}

	static void printTree(TreeNode n) {
		if (n == null)
			return;
		System.out.println(n.val);
		printTree(n.left);
		printTree(n.right);
	}

	static List<List<TreeNode>> levelWiseListNodesGayle(TreeNode n) {
		List<List<TreeNode>> result = new ArrayList<>();
		List<TreeNode> current = new ArrayList<>();
		current.add(n);
		while (!current.isEmpty()) {
			result.add(current);
			List<TreeNode> parent = current;
			current = new ArrayList<>();
			for (TreeNode r : parent) {
				if (r.left != null)
					current.add(r.left);
				if (r.right != null)
					current.add(r.right);
			}
		}
		return result;
	}

	static void levelOrderTraversal(TreeNode n) {
		if (n == null)
			return;
		LinkedList<TreeNode> q = new LinkedList<>();
		q.offer(n);
		q.offer(null);
		List<Integer> lst = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode r = q.poll();
			if (r == null) {
				for (Integer integer : lst) {
					System.out.print(integer + " ");
				}
				System.out.println();
				lst.clear();
				if (!q.isEmpty())
					q.add(null);

			} else {
				lst.add(r.val);
				if (r.left != null)
					q.offer(r.left);
				if (r.right != null)
					q.offer(r.right);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = createBST(new int[] { 11, 22, 14, 234, 12, 33, 1234 });
		levelOrderTraversal(root);
	}
}
