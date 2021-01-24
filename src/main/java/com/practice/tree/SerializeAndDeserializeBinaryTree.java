package com.practice.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "x";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deseri(queue);
    }

    TreeNode deseri(LinkedList<String> queue) {
        String s = queue.poll();
        if (s.equals("x")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = deseri(queue);
        node.right = deseri(queue);
        return node;
    }
}
