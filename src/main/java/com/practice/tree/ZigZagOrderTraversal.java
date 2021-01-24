package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRightInOutPut = true;
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(root.val);
        result.add(lst);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Stack<TreeNode> list = new Stack<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.remove();

                if (leftToRightInOutPut) {

                    if (node.left != null) {
                        list.push(node.left);
                    }

                    if (node.right != null) {
                        list.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        list.push(node.right);
                    }

                    if (node.left != null) {
                        list.push(node.left);
                    }
                }
            }
            ArrayList<Integer> l = new ArrayList<>();
            while (!list.isEmpty()) {
                TreeNode n = list.pop();
                queue.add(n);
                l.add(n.val);
            }
            if (!l.isEmpty()) {
                result.add(l);
            }
            leftToRightInOutPut = !leftToRightInOutPut;
        }
        return result;
    }
}
