package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
	List<Integer> lst = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return lst;
		// left
		inorderTraversal(root.left);
		// node
		lst.add(root.val);
		// right
		inorderTraversal(root.right);
		return lst;
	}

	TreeNode prev;

	void traverse(TreeNode root) {
		if (root == null)
			return;
		traverse(root.left);
		if (prev != null && prev.val > root.val) {
			System.out.println("Tree out of order");
		}
		prev = root;
		traverse(root.right);
	}

	List<Integer> inOrderIterative(TreeNode root) {
		if (root == null)
			return lst;
		LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
		TreeNode rootbkp = root;
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			TreeNode t = stk.pop();
			lst.add(t.val);
			root = t.right;
		}
		return lst;
	}

	List<Integer> preOrderIterative(TreeNode root) {
		if (root == null)
			return lst;
		LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
		TreeNode rootbkp = root;
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				lst.add(root.val);
				stk.push(root);
				root = root.left;
			}
			TreeNode t = stk.pop();
			root = t.right;
		}
		return lst;

	}

	public static void main(String[] args) {
		InorderTraversal i = new InorderTraversal();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);

		TreeNode prev;
		i.traverse(root);
	}
}
