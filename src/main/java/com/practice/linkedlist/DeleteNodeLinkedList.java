package com.practice.linkedlist;


public class DeleteNodeLinkedList {

    /**
     * 237. Delete Node in a Linked List
     * https://leetcode.com/problems/delete-node-in-a-linked-list/
     * @param node
     */
    public void deleteNode(ListNode node) {

        while(node!=null){

            if(node.next!=null){
                node.val = node.next.val;
            }

            if(node.next.next==null){
                node.next=null;
                break;
            }

            node = node.next;
        }
    }
}
