package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            ArrayList<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.remove();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            result.add(currentLevel);
        }

        return result;

    }

}
