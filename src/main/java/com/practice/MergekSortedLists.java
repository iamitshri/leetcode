package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {

		if (lists == null || lists.size() == 0)
			return null;

		Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1 == null || o2 == null)
					return -1;
				if (o1.val > o2.val)
					return 1;
				else if (o1.val < o2.val)
					return -1;

				return 0;
			}
		};

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);

		for (ListNode listNode : lists) {
			if (listNode != null)
				pq.add(listNode);
		}

		ListNode min = null, head = null, curr = null;
		while (!pq.isEmpty()) {
			min = pq.poll();
			if (head == null) {
				head = min;
				curr = head;
			} else {
				curr.next = min;
				curr = curr.next;

			}

			if (min.next != null)
				pq.offer(min.next);
		}
		return head;

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
		MergekSortedLists m = new MergekSortedLists();
		ArrayList<ListNode> l1 = new ArrayList<ListNode>();
		l1.add(head);
		ListNode n1 = m.mergeKLists(l1);
		while (n1 != null) {
			System.out.print(" " + n1.val);
			n1 = n1.next;
		}

	}

}
