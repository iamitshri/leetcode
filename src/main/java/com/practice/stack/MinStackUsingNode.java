package com.practice.stack;

class MinStackUsingNode {

    Node head;

    /**
     * initialize your data structure here.
     */
    public MinStackUsingNode() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class Node {

    int val;
    Node next;
    int min;

    public Node(int val, int min, Node head) {
        this.val = val;
        this.min = min;
        this.next = head;
    }
}
