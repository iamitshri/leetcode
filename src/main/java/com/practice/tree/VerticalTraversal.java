package com.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class VerticalTraversal {

    Map<Integer, List<Integer>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        helper(root, 0, 0);
        List<List<Integer>> ints = new ArrayList<>();
        for (Integer s : map.keySet()) {
            List<Integer> list = map.get(s);
            Collections.sort(list);
            ints.add(list);
        }
        return ints;
    }

    void helper(TreeNode root, Integer x, Integer y) {

        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x)
           .add(root.val);
        helper(root.left, x - 1, y - 1);
        helper(root.right, x + 1, y - 1);
    }

    public static void main(String[] args) {
        var left = new TreeNode(10, new TreeNode(1), new TreeNode(15));
        var right = new TreeNode(30, new TreeNode(25, new TreeNode(22), null), new TreeNode(35));
        TreeNode root = new TreeNode(20, left, right);
        VerticalTraversal v = new VerticalTraversal();
        final List<List<Integer>> lists = v.verticalTraversal(root);

        for (var list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

}
