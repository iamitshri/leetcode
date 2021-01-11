package com.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public Node copyRandomList(Node head) {

        Node current = head;
        Map<Node,Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(current!=null){
            Node n = new Node(current.val);
            n.random=current.random;
            tail.next=n;
            tail=tail.next;
            map.put(current,n);
            current=current.next;
        }

        current = dummy.next;
        while(current!=null){
            current.random = map.get(current.random);
            current=current.next;
        }
        return dummy.next;
    }

    public Node copyRandomList2(Node head) {

        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node newHead = null;
        Node tail = null;
        while (temp != null) {

            Node newNode = new Node(temp.val);
            newNode.random = temp.random;
            if (tail != null) {
                tail.next = newNode;
                tail = tail.next;
            } else {
                tail = newHead = newNode;
            }
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = newHead;
        while (temp != null) {
            temp.random = map.get(temp.random);
            temp = temp.next;
        }
        return newHead;
    }
}
