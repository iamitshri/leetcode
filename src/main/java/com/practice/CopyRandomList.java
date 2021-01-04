package com.practice;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {

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
