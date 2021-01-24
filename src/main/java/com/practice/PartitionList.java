package com.practice;

import com.practice.linkedlist.ListNode;

public class PartitionList {

	/**
	 * Given a linked list and a value x, partition it such that all nodes less
	 * than x come before nodes greater than or equal to x.
	 * 
	 * You should preserve the original relative order of the nodes in each of
	 * the two partitions.
	 * 
	 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
	 */

	public static ListNode append(ListNode head, ListNode node) {
		// make this node pointer run to the end of list and append the new node
		ListNode runner = head;

		// making sure node has no further connections
		node.next = null;
		if (head != null) {
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = node;
		} else {
			head = node;

		}

		return head;
	}

	public static ListNode partition(ListNode head, int x) {

		if (head == null)
			return null;

		ListNode lessThanX = null, greaterThanX = null;
		ListNode firstNode = head;

		while (firstNode != null) {
			if (firstNode.val >= x) {
				ListNode temp = firstNode;
				firstNode = firstNode.next;
				greaterThanX = append(greaterThanX, temp);

			} else {
				ListNode temp = firstNode;
				firstNode = firstNode.next;
				lessThanX = append(lessThanX, temp);
			}
		}

		return appendLists(lessThanX, greaterThanX);

	}

	public static ListNode appendLists(ListNode lessThanX, ListNode greaterThanX) {
		ListNode runnerNode = lessThanX;
		if (lessThanX != null) {
			while (runnerNode.next != null) {
				runnerNode = runnerNode.next;
			}
			runnerNode.next = greaterThanX;
		} else {
			lessThanX = greaterThanX;
		}
		return lessThanX;
	}

}
