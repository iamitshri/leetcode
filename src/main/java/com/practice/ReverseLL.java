package com.practice;

import com.practice.linkedlist.ListNode;

class ll {
	ll next;
	int val;
}

public class ReverseLL {

	static void printLL(ll head) {
		if (head == null)
			return;
		System.out.print(head.val + " ");
		printLL(head.next);

	}

	// Without Extra memory
	static void reverseLLInPlace(ll head) {
		ll result = null;
		ll currentNode = head;
		while (head != null) {
			currentNode = head.next;

			head.next = result;
			result = head;

			head = currentNode;
		}
		printLL(result);
	}

	static void reverseLL(ll head) {
		/**
		 * 
		 * 1 -> 2 > 3 -> 4
		 * 
		 * 4 -> 3 -> 2 -> 1
		 * 
		 * 1 -> 2
		 * 
		 * 1 head.next = temp ;
		 */

		ll temp = null;
		ll temp2 = null;
		while (head != null) {
			temp2 = temp;

			// save current value
			temp = new ll();
			temp.val = head.val;

			// make the current value as head
			// by pointing temp's next ll so far
			temp.next = temp2;

			// move ahead
			head = head.next;
		}

		printLL(temp);

		// 2 - > 1

	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode temp = head;
		ListNode rev = null;
		while (temp != null) {
			ListNode next = temp.next;
			temp.next = rev;
			rev = temp;
			temp = next;
		}

		return rev;

	}

	public ListNode reverseRecursiveList(ListNode head) {
		if (head == null)
			return null;
		ListNode first = head;
		if (head.next == null)
			return head;
		ListNode rev = reverseList(head.next);
		first.next.next = first;
		first.next = null;
		return rev;

	}

	public static void main(String... strings) {
		ll head = new ll();
		ll temp = head;
		for (int i = 1; i < 10; i++) {
			ll t = new ll();
			t.val = i * 2;
			head.next = t;
			head = head.next;
		}
		printLL(temp);
		System.out.println();
		reverseLL(temp);
		System.out.println();
		reverseLLInPlace(temp);
	}

}
