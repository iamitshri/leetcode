package com.practice.linkedlist;

public class ReverseInGroupsOfK {

    public ListNode reverseKGroup(ListNode head, int k) {

        // 1 2 3 4 5
        // reverse k and then

        ListNode node = head;
        ListNode start = head;
        ListNode rev = null;
        ListNode runner = null;
        ListNode prevSubList = null;
        // 1 2 3 4 5 6
        while (true) {

            int cnt = 1;
            while (node != null && cnt <= k) {
                node = node.next;
                cnt++;
            }
            if (node == null && cnt <= k) {
                break;
            }

            runner = start;
            for (int i = 0; i < k && runner != null; i++) {
                ListNode next = runner.next;
                runner.next = rev;
                rev = runner;
                runner = next;
            } // 6 5

            if (prevSubList == null) {
                head = rev; //
            } else {
                prevSubList.next = rev; // 2 1 4 3  6 5
            }

            start.next = runner; //   2 1 4 3 5 6
            prevSubList = start; // 1
            node = runner; // 3
            start = runner;
            if (node == null) {
                break;
            }
        }
        return head;
    }
}
