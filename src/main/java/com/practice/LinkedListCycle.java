package com.practice;

import com.practice.linkedlist.ListNode;

public class LinkedListCycle {



	public boolean hasCycle(ListNode head) {

		if (head == null || head.next == null)
			return false;

		if (head.next == head)
			return true;

		ListNode first = head;
		ListNode runner = null;
		if (head.next.next == null) {
			return false;
		} else {
			runner = head.next.next;
		}

		while (first != null && runner != null) {

			first = first.next;

			runner = runner.next;
			if (runner != null)
				runner = runner.next;

			if (first == runner)
				return true;

		}

		return false;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
