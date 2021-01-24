package com.practice;

import com.practice.linkedlist.ListNode;

/**
 * 
 */

public class SortList {

	class partitionLists {
		ListNode lessThanX, greaterThanX, equalToX;

		partitionLists() {
			lessThanX = greaterThanX = equalToX = null;
		}
	}

	/* Sort a linked list in O(n log n) time using constant space complexity */
	public ListNode sortList(ListNode head) {

		/*
		 * quick sort
		 * 
		 * lets choose pivot as first node each time and partition the list
		 * based on that
		 */
		if (head == null)
			return null;

		if (head.next == null)
			return head;

		SortList.partitionLists p = this.new partitionLists();

		p = partition(head, p);

		p.lessThanX = sortList(p.lessThanX);
		p.greaterThanX = sortList(p.greaterThanX);

		ListNode temp = appendLists(p.lessThanX, p.equalToX);
		return appendLists(temp, p.greaterThanX);

	}

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

	public static SortList.partitionLists partition(ListNode head, SortList.partitionLists p) {
		if (head == null)
			return null;
		ListNode firstNode = head;
		int x = head.val;
		while (firstNode != null) {
			if (firstNode.val == x) {
				ListNode temp = firstNode;
				firstNode = firstNode.next;
				p.equalToX = append(p.equalToX, temp);

			} else if (firstNode.val > x) {
				ListNode temp = firstNode;
				firstNode = firstNode.next;
				p.greaterThanX = append(p.greaterThanX, temp);

			} else {
				ListNode temp = firstNode;
				firstNode = firstNode.next;
				p.lessThanX = append(p.lessThanX, temp);
			}
		}
		return p;
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

	/**
	 * This solution is accepted by Leetcode online judge
	 * 
	 * @param head
	 * @return
	 */
	public ListNode mergeSortList(ListNode head) {

		if (head == null)
			return null;

		if (head.next == null)
			return head;
		ListNode middleNode = findMiddleNode(head);

		ListNode secondHalf = middleNode.next;

		middleNode.next = null;

		ListNode firstHalf = head;

		if (firstHalf == middleNode)
			firstHalf = middleNode;
		else {
			// make the first half to end with null
			while (firstHalf != null && firstHalf.next != middleNode) {
				firstHalf = firstHalf.next;
			}

			if (firstHalf != null)
				firstHalf.next = null;

			firstHalf = head;
		}

		firstHalf = mergeSortList(firstHalf);
		secondHalf = mergeSortList(secondHalf);

		if ((firstHalf != null && firstHalf.next == null) && (middleNode != null && middleNode.next == null)
				&& (firstHalf == middleNode)) {
			return merge(firstHalf, secondHalf);
		}

		ListNode temp = merge(firstHalf, middleNode);
		return merge(temp, secondHalf);
	}

	public ListNode merge(ListNode first, ListNode second) {

		ListNode result = null, resultTail = null;

		if (first == null && second == null)
			return null;

		while (first != null && second != null) {

			if (first.val < second.val) {
				if (result == null) {
					result = first;
					// First node head & tail are same offcourse
					resultTail = result;

				} else {
					resultTail.next = first;
					resultTail = first;

				}
				first = first.next;

			} else {

				if (result == null) {
					result = second;

					// First node head & tail are same offcourse
					resultTail = result;

				} else {
					resultTail.next = second;
					resultTail = second;

				}
				second = second.next;
			}
		}

		if (first == null && second != null) {
			while (second != null) {
				if (result == null) {
					result = second;

					// First node head & tail are same offcourse
					resultTail = result;

				} else {
					resultTail.next = second;
					resultTail = second;

				}
				second = second.next;
			}
		}
		if (second == null && first != null) {
			while (first != null) {

				if (result == null) {
					result = first;

					// First node head & tail are same offcourse
					resultTail = result;

				} else {
					resultTail.next = first;
					resultTail = first;

				}
				first = first.next;
			}
		}
		return result;

	}

	/**
	 * find the middle node & return list starting from middle node
	 * 
	 * @param head
	 * @return
	 */
	public ListNode findMiddleNode(ListNode head) {

		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode first = head;

		ListNode runner = head.next.next;

		while (first != null && runner != null) {
			first = first.next;

			runner = runner.next;
			if (runner != null) {
				runner = runner.next;
			}
		}

		return first;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] n = new int[] { 99999, 12, 99, 0, -1, 1, 2, 3, 4, 5 };
		ListNode head = null, tail = null;
		ListNode node = new ListNode(n[0]);
		head = tail = node;

		for (int i = 1; i < n.length; i++) {
			ListNode temp = new ListNode(n[i]);
			tail.next = temp;
			tail = temp;
		}

		SortList obj = new SortList();

		// ListNode result = obj.findMiddleNode(head);

		// ListNode result = obj.sortList(head);
		ListNode result = obj.mergeSortList(head);

		while (result != null) {
			System.out.print(" " + result.val);
			result = result.next;

		}
	}
}
