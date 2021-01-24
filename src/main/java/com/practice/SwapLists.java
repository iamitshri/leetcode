package com.practice;

import com.practice.linkedlist.ListNode;

public class SwapLists {

	/*
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed
	 */
	public static ListNode swapPairs(ListNode head) {

		if (head == null) {
			return head;
		}
		ListNode returnThisList = null;
		int cnt = 2;
		ListNode curr = head;
		ListNode temp = head;
		while (cnt > 0 && temp != null) {
			temp = temp.next;
			cnt--;
		}
		if (cnt > 0) {
			// we dint reach all the 2 nodes
			returnThisList = head;
		} else {
			ListNode prevResult = null;
			ListNode newHead = null;
			if (temp != null) {
				prevResult = swapPairs(temp);
			}
			if (curr != null && curr.next != null) {
				curr.next.next = curr;
				newHead = curr.next;

				curr.next = prevResult;

				returnThisList = newHead;
			}
		}

		return returnThisList;
	}

	/**
	 * LeetCode solution
	 * 
	 * @param head
	 * @return
	 */
	static ListNode reverseInPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		prev.next = head;
		ListNode p = head;
		while (p != null && p.next != null) {
			ListNode q = p.next;
			ListNode r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;

		}

		return dummy.next;

	}

	public static void main(String[] args) {
		// ListUtil.printLL(swapPairs(ListUtil.getListNodes(new int
		// []{1,2,3,4,5,6,7,8,9,0})));
		ListUtil.printLL(reverseInPairs(ListUtil.getListNodes(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 })));
	}
}
