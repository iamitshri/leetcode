package com.practice.tree;


import java.util.Stack;

public class Traversal {

    void recursivePostOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        recursivePostOrderTraversal(node.left);
        recursivePostOrderTraversal(node.right);
        System.out.println(node.val);
    }

    void iterativePostOrderTraversal(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        if (node == null) {
            return;
        }

        while (true) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            var item = stack.peek();
            if (item.right == null) {
                item = stack.pop();
                System.out.println(item.val);
                if (stack.isEmpty()) {
                    break;
                }
                while (!stack.isEmpty() && stack.peek().right == item) {
                    item = stack.pop();
                    System.out.println(item.val);
                }
            }
            if (stack.isEmpty()) {
                break;
            }
            node = stack.peek().right;

        }
    }

    void recursivePreOrderTraversal(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.println(node.val);
        recursivePreOrderTraversal(node.left);
        recursivePreOrderTraversal(node.right);
    }

    void iteratePreOrderTraversal(TreeNode node) {
        // root left right
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (true) {

            while (node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            var item = stack.pop();
            node = item.right;

        }

    }

    // inorder
    void recursiveInOrderTraversal(TreeNode root) {
        // Left , root, right
        if (root == null) {
            return;
        }

        recursiveInOrderTraversal(root.left);
        System.out.println(root.val);
        recursiveInOrderTraversal(root.right);
    }

    void iterativeInOrderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        // left,root, right
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode v = stack.pop();
            System.out.println(v.val);
            root = v.right;
        }
    }

    public static void main(String[] args) {

        var left = new TreeNode(10, new TreeNode(1), new TreeNode(15));
        var right = new TreeNode(30, new TreeNode(25, new TreeNode(22), null), new TreeNode(35));
        TreeNode root = new TreeNode(20, left, right);
        Traversal t = new Traversal();
//   t.recursiveInOrderTraversal(root);
//        t.iterativeInOrderTraversal(root);
        //t.recursivePreOrderTraversal(root);
        //t.iteratePreOrderTraversal(root);
        //t.recursivePostOrderTraversal(root);
        //t.iterativePostOrderTraversal(root);
    }
}
