package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        helper(root, list, 0);
        return list;
    }

    void helper(TreeNode root, List<Integer> list, int level) {

        if (list.size() == level) {
            list.add(root.val);
        }

        if (root.right != null) {
            helper(root.right, list, level + 1);
        }

        if (root.left != null) {
            helper(root.left, list, level + 1);
        }
    }
}
