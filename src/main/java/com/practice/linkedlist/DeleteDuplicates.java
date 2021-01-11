package com.practice.linkedlist;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }

        ListNode temp = head;
        while (temp != null && temp.val == head.val) {
            temp = temp.next;
        }

        return deleteDuplicates(temp);

    }
}
