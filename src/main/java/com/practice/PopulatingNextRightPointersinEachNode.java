package com.practice;

public class PopulatingNextRightPointersinEachNode {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {

		if (root == null)
			return;
		TreeLinkNode leftomstNode = root, curr = null;
		while (leftomstNode != null) {

			curr = leftomstNode;
			while (curr != null) {

				// 1. point left node to right node
				if (curr.left != null) {
					curr.left.next = curr.right;
				}

				// 2. point right node to sibling's left node
				if (curr.next != null && curr.right != null) {
					curr.right.next = curr.next.left;

				}
				curr = curr.next;

			}
			leftomstNode = leftomstNode.left;

		}

	}

	public void connect_any_binary_tree(TreeLinkNode root) {

		if (root == null)
			return;

		TreeLinkNode leftomstNode = root, curr = null;
		while (leftomstNode != null) {

			curr = leftomstNode;
			while (curr != null) {

				// 1. point left node to right node
				if (curr.left != null && curr.right != null) {
					curr.left.next = curr.right;
				}

				// 2. point node to sibling's leftmost node
				if (curr.next != null) {

					TreeLinkNode node = null;
					TreeLinkNode currNode = null;

					currNode = curr;

					while (currNode != null && currNode.next != null) {
						if (currNode.next.left == null && currNode.next.right == null) {
							currNode = currNode.next;

						} else {

							node = currNode.next.left;
							if (node == null)
								node = currNode.next.right;

							break;
						}
					}

					if (curr.right != null)
						curr.right.next = node;

					// if curr right is null & curr left is not then point
					// current left to above node
					if (curr.left != null) {
						if (curr.right == null)
							curr.left.next = node;

					}

				}
				curr = curr.next;

			}
			if (leftomstNode.left != null)
				leftomstNode = leftomstNode.left;
			else if (leftomstNode.right != null)
				leftomstNode = leftomstNode.right;
			else {
				TreeLinkNode temp = leftomstNode;
				temp = temp.next;
				if (temp == null) {
					return;
				}
				leftomstNode = temp;
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
