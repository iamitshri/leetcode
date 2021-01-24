package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindLeavesBinaryTree {


    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        height(root);

        return list;

    }


    int height(TreeNode node) {

        if (node == null) {
            return -1;
        }

        int level = Math.max(height(node.left), height(node.right)) + 1;

        if (list.size() < level + 1) {
            list.add(new ArrayList<Integer>());
        }

        list.get(level)
            .add(node.val);
        return level;

    }


    Map<Integer, List<Integer>> map = new TreeMap<>();
    public List<List<Integer>> findLeavesMySolution(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        map.put(0, new ArrayList<>());

        helper(root);

        for (Integer key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;

    }

    Result helper(TreeNode root) {

        if (root == null) {
            return new Result(false, Integer.MIN_VALUE);
        }

        if (root.left == null && root.right == null) {  // leaf
            map.get(0)
               .add(root.val);
            return new Result(true, 0);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        Result result = new Result();
        if (left.leaf == true && right.leaf == true) {
            result.leaf = true;
        } else {
            result.leaf = false;
        }

        result.level = Math.max(left.level, right.level) + 1;
        if (!map.containsKey(result.level)) {
            map.put(result.level, new ArrayList<>());
        }
        map.get(result.level)
           .add(root.val);
        return result;
    }

    public class Result {

        boolean leaf;
        int level;

        Result() {
        }

        Result(boolean l, int ll) {
            leaf = l;
            level = ll;
        }

    }

}
