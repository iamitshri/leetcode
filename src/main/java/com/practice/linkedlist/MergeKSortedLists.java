package com.practice.linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for (ListNode l : lists) {
            if (l != null) {
                pq.offer(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            ListNode n = pq.poll();
            if (n.next != null) {
                pq.offer(n.next);
            }

            tail.next = n;
            tail = tail.next;
        }
        return dummy.next;
    }
}
