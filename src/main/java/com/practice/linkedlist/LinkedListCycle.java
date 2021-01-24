package com.practice.linkedlist;


public class LinkedListCycle {

    /**
     * 141. Linked List Cycle
     * https://leetcode.com/problems/linked-list-cycle/
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null){

            fast=fast.next;

            if(fast==slow)
                return true;

            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }

        return false;
    }
}
