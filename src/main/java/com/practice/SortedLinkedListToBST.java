package com.practice;

import com.practice.linkedlist.ListNode;

public class SortedLinkedListToBST {
	/***
	 * Given a singly linked list where elements are sorted in ascending order,
	 * convert it to a height balanced BST.
	 * 
	 * 
	 */
	ListNode ll;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		ll = head;
		return createBSTFromLinkedList(0, len - 1);

	}

	TreeNode createBSTFromLinkedList(int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;

		TreeNode left = createBSTFromLinkedList(start, mid - 1);
		TreeNode parent = new TreeNode(ll.val);
		parent.left = left;
		ll = ll.next;

		TreeNode right = createBSTFromLinkedList(mid + 1, end);
		parent.right = right;
		return parent;

	}
}
