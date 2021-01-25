package com.practice.tree;

public class PopulatingNextRightPointersEachNode {

    static class NodeWNext {

        public int val;
        public NodeWNext left;
        public NodeWNext right;
        public NodeWNext next;

        public NodeWNext() {
        }

        public NodeWNext(int _val) {
            val = _val;
        }

        public NodeWNext(int _val, NodeWNext _left, NodeWNext _right, NodeWNext _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public NodeWNext connect(NodeWNext root) {
        NodeWNext temp1 = root;
        NodeWNext cur = null;
        while (root != null) {
            cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            root = root.left;
        }
        return temp1;
    }
}
