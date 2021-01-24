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
}
