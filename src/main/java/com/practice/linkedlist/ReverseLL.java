package com.practice.linkedlist;

public class ReverseLL {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
