package com.practice.linkedlist;



public class MiddleNode {

    /**
     * 876. Middle of the Linked List
     * https://leetcode.com/problems/middle-of-the-linked-list/submissions/
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        ListNode fast=null, slow=null;

        fast = head;
        slow = head;

        while(fast!=null){
            fast= fast.next;
            if(fast!=null){
                slow=slow.next;
                fast =fast.next;
            }
        }
        // 1 2
        return slow;
    }

    public ListNode middleNode2(ListNode head) {

        if(head==null)
            return null;

        ListNode fp=head;
        ListNode sp=head;
        // 1 2
        // 1 2 3
        while(fp!=null && fp.next!=null){
            sp = sp.next;
            fp=fp.next.next;
        }


        return sp;

    }
}
