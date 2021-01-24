package com.practice;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class PopulatingNextRightPointers {

	/**
	 * Populate each next pointer to point to its next right node. If there is
	 * no next right node, the next pointer should be set to NULL.
	 * 
	 * Initially, all next pointers are set to NULL.
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space. You may assume that it is a
	 * perfect binary tree (ie, all leaves are at the same level, and every
	 * parent has two children).
	 * 
	 * @param args
	 */

	public void connect(TreeLinkNode root1) {
		if (root1 == null)
			return;
		TreeLinkNode ref = root1;
		while (ref.left != null) {
			TreeLinkNode root = ref;
			while (root != null) {
				if (root.left != null) {
					root.left.next = root.right;
				}
				if (root.next != null && root.right != null) {
					root.right.next = root.next.left;
				}
				root = root.next;
			}
			ref = ref.left;
		}
	}

	public static void main(String[] args) {

	}
}
