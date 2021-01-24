package com.practice.linkedlist;


public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode temp = head;
        ListNode current = head;
        ListNode prev = null;
        // 1 2 3

        while (current != null && current.next != null) {

            ListNode n = current.next;  // 2
            temp = n.next; // 3
            n.next = current; // 2->1
            current.next = temp; // 2->1->3

            if (prev != null) {
                prev.next = n;
            } else {
                head = n;
            }

            prev = current;
            current = current.next;
        }

        return head;
    }
}
