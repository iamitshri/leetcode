package com.practice.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeDeserializeTree {

    public String serialize(TreeNode root) {

        if(root==null)
            return "";
        return serializationHelper(root);
    }

    String serializationHelper(TreeNode node){
        if(node==null)
            return "X";

        String leftTree = serializationHelper(node.left);
        String rightTree = serializationHelper(node.right);
        return node.val +", "+leftTree+", "+rightTree;

    }
    public TreeNode deserialize(String data) {

        TreeNode node=null;
            if(data==null || data.isEmpty())
                return node;

        String [] arr= data.split(", ");
        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(arr));
        return helper(queue);
    }
    TreeNode helper(LinkedList<String> queue){

        String nodeStr = queue.remove();
        if(nodeStr.equals("X")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodeStr.trim()));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }

    public static void main(String[] args) {
        var left = new TreeNode(10, new TreeNode(1), new TreeNode(15));
        var right = new TreeNode(30, new TreeNode(25, new TreeNode(22), null), new TreeNode(35));
        TreeNode root = new TreeNode(1, new TreeNode(2),new TreeNode(3));
        SerializeDeserializeTree s = new SerializeDeserializeTree();
        String serialized = s.serialize(root);
        System.out.println("Serialized:"+serialized);
        TreeNode newRoot = s.deserialize(serialized);
        String newSerialized = s.serialize(newRoot);
        System.out.println(" --<>--"+ newSerialized.equals(serialized));
    }

}
