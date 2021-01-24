package com.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

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

public class CopyListwithRandomPointer {

    Map<Node, Node> visited = new HashMap<>();

    Node get(Node node) {

        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        visited.put(node, new Node(node.val));

        return visited.get(node);

    }

    /**
     * 138. Copy List with Random Pointer
     * https://leetcode.com/problems/copy-list-with-random-pointer/
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldList = head;
        Node newList = new Node(head.val);
        visited.put(oldList, newList);

        while (oldList != null) {
            newList.next = get(oldList.next);
            newList.random = get(oldList.random);

            oldList = oldList.next;
            newList = newList.next;
        }

        return visited.get(head);
    }
}
