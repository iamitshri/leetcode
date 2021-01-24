package com.practice.linkedlist;


public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode temp = head;
        ListNode slow = head;
        int cnt = 0;
        while (cnt < n && temp != null) {
            temp = temp.next;
            cnt++;
        }

        if (temp == null) {
            return head.next;
        }

        while (temp.next != null) {
            temp = temp.next;
            slow = slow.next;
        }

        if (temp.next == null) {
            if (slow.next != null) {
                slow.next = slow.next.next;
            } else {
                slow.next = null;
            }
        }
        return head;
    }
}
