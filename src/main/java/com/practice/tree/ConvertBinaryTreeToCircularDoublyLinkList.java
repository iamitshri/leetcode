package com.practice.tree;

class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class ConvertBinaryTreeToCircularDoublyLinkList {

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }

        Node leftList = treeToDoublyList(root.left);
        Node rightList = treeToDoublyList(root.right);

        root.left = root.right = root;

        return merge(merge(leftList, root), rightList);

    }

    Node merge(Node leftList, Node rightList) {

        if (leftList == null) {
            return rightList;
        }

        if (rightList == null) {
            return leftList;
        }

        Node leftLast = leftList.left;
        Node rightLast = rightList.left;

        leftLast.right = rightList;
        rightList.left = leftLast;

        leftList.left = rightLast;
        rightLast.right = leftList;

        return leftList;
    }

}
