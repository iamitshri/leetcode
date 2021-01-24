package com.practice;

import com.practice.linkedlist.ListNode;

public class ListUtil {

	public static Node getList(int[] arr) {
		Node head = new Node();
		Node headPtr = head;
		for (int i = 0; i < arr.length; i++) {
			Node node = new Node();
			node.val = arr[i];
			head.next = node;
			head = head.next;
		}
		return headPtr.next;
	}

	public static void printLL(Node head) {
		if (head == null)
			return;
		System.out.print(head.val + " ");
		printLL(head.next);

	}

	public static void printLL(ListNode head) {
		if (head == null)
			return;
		System.out.print(head.val + " ");
		printLL(head.next);

	}

	public static ListNode getListNodes(int[] arr) {
		ListNode head = new ListNode(0);
		ListNode headPtr = head;
		for (int i = 0; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);

			head.next = node;
			head = head.next;
		}
		return headPtr.next;
	}

	public static void main(String[] s) {
		Node head = getList(new int[] { 12, 34, 1, 33, 13 });
		printLL(head);
	}
}
