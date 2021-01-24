package com.practice;

import com.practice.linkedlist.ListNode;

public class MergekSortedListsDivideAndConquer {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length==0)
			return null;
		return mergeKLists(lists, 0, lists.length - 1);

	}

	public ListNode mergeKLists(ListNode[] lists, int s, int e) {
		if (s > e) {
			return null;
		}
		
		if(s==e)
			return lists[s];

		int m = (s + e) / 2;
		ListNode m1 = mergeKLists(lists, s, m);
		ListNode m2 = mergeKLists(lists, m + 1, e);
		return mergeTwoLists(m1, m2);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(0);
		ListNode dummy = temp;
		if (l1 == null && l2 == null) {
			return l1;
		}

		if (l1 == null && l2 != null) {
			return l2;
		}

		if (l1 != null && l2 == null) {
			return l1;
		}
		ListNode t1 = l1;
		ListNode t2 = l2;
		while (t1 != null && t2 != null) {
			if (t1.val <= t2.val) {
				dummy.next = t1;
				t1 = t1.next;
				dummy = dummy.next;
			} else {
				dummy.next = t2;
				t2 = t2.next;
				dummy = dummy.next;
			}
		}

		if (t1 == null && t2 != null) {
			dummy.next = t2;
			dummy = dummy.next;
		}
		if (t2 == null && t1 != null) {
			dummy.next = t1;
			dummy = dummy.next;
		}
		return temp.next;
	}
	
	public static void main(String [] s){
		ListNode[] lists =  new ListNode[]{new ListNode(0),new ListNode(1)};
		MergekSortedListsDivideAndConquer d= new MergekSortedListsDivideAndConquer();
		 
		
		System.out.println(d.mergeKLists(lists));
	}
}