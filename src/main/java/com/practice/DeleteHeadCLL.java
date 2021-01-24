package com.practice;

import com.practice.linkedlist.ListNode;

public class DeleteHeadCLL {
	public ListNode deleteAtHead(ListNode head) {
		if (head == null)
			return null;
		ListNode curr = head;
		// Traverse to tail
		while (curr.next != head) {
			curr = curr.next;
		}
		curr.next = head.next;
		head.next = null;
		head = curr.next;
		return head;
	}
}
