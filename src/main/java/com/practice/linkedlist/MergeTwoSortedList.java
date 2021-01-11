package com.practice.linkedlist;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {

        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);

        ListNode tail = dummy;
        ListNode newNode = null;
        while (l1 != null && l2 != null) {

            if (l1.val == l2.val) {

                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
                tail.next = l2;
                l2 = l2.next;

            } else if (l1.val < l2.val) {

                tail.next = l1;
                l1 = l1.next;

            } else {

                tail.next = l2;
                l2 = l2.next;

            }

            tail = tail.next;
        }

        if (l2 != null) {
            tail.next = l2;
        } else if (l1 != null) {
            tail.next = l1;
        }

        return dummy.next;

    }
}
