package com.practice.linkedlist;

import java.util.HashSet;

public class IntersectionTwoLinkedList {

    /*
    160. Intersection of Two Linked Lists
    https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while(a!=b){
            a= a==null?headB: a.next;
            b = b==null?headA:b.next;
        }
        return a;
    }

    public ListNode getIntersectionNodeUsingSet(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

}
