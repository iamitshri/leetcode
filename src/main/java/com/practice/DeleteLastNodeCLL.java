package com.practice;

import com.practice.linkedlist.ListNode;

public class DeleteLastNodeCLL {
	public ListNode deleteAtTail(ListNode head) {

		if (head == null)
			return null;

		ListNode temp = head;

		if (temp.next == head) {
			return null;
		}

		if (temp.next != null && temp.next.next == head) {
			temp.next.next = null;
			temp.next = head;

			return head;
		}

		temp = temp.next;
		while (temp != head && temp.next != null) {
			if (temp.next.next == head) {
				temp.next.next = null;
				temp.next = head;

			}
			temp = temp.next;
		}

		return head;

	}
}
