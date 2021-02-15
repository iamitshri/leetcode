package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        // stack
        // go left , process node, go right
    }
}
