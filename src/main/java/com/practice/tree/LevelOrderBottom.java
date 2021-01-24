package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<List<Integer>> stackOfList = new Stack<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            var l = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                l.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }

            if (!l.isEmpty()) {
                stackOfList.push(l);
            }

        }

        while (!stackOfList.isEmpty()) {
            result.add(stackOfList.pop());
        }
        return result;
    }
}
