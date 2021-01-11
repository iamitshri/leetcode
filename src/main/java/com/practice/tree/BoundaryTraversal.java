package com.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        leftB(root.left, result);
        leaves(root, result);
        rightB(root.right, result);
        return result;
    }

    void leftB(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            result.add(root.val);
            leftB(root.left, result);
        } else if (root.right != null) {
            result.add(root.val);
            leftB(root.right, result);
        }
    }

    void rightB(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            rightB(root.right, result);
            result.add(root.val);
        } else if (root.left != null) {
            rightB(root.left, result);
            result.add(root.val);
        }
    }

    void leaves(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        leaves(root.left, result);
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        leaves(root.right, result);
    }


}
