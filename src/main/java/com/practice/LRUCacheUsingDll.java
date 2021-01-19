package com.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheUsingDll {
    public static void main(String[] args) {
        /**
         *
         ["LRUCache","get","put","get","put","put","get","get"]
         [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
         */
        LRUCacheUsingDll lc = new LRUCacheUsingDll(2);
        lc.put(2, 6);
        lc.get(1);
        lc.put(1, 5);
        lc.put(1, 2);
        lc.get(1);
        lc.get(2);
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    void addNode(Node node) {
        Node headNext = head.next;

        head.next = node;
        node.prev = head;

        node.next = headNext;
        headNext.prev = node;
    }

    void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    public LRUCacheUsingDll(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            remove(map.get(key));
        }else if (map.size() == capacity) {
            Node nodeToBeRemoved = tail.prev;
            map.remove(nodeToBeRemoved.key);
            remove(nodeToBeRemoved);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addNode(newNode);
    }
}
