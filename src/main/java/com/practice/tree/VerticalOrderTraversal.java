package com.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalTraversalMine(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0});
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        map.put(0, new TreeMap<Integer, List<Integer>>());
        map.get(0)
           .put(0, new ArrayList<>());
        map.get(0)
           .get(0)
           .add(root.val);

        while (!queue.isEmpty()) {

            Object[] obj = queue.remove();
            TreeNode node = (TreeNode) obj[0];
            int distance = (int) obj[1];
            int level = (int) obj[2];

            if (node.left != null) {
                queue.add(new Object[]{node.left, distance - 1, level + 1});

                if (!map.containsKey(distance - 1)) {
                    map.put(distance - 1, new TreeMap<>());
                }

                if (!map.get(distance - 1)
                        .containsKey(level + 1)) {
                    map.get(distance - 1)
                       .put(level + 1, new ArrayList<>());
                }

                map.get(distance - 1)
                   .get(level + 1)
                   .add(node.left.val);
            }

            if (node.right != null) {
                queue.add(new Object[]{node.right, distance + 1, level + 1});

                if (!map.containsKey(distance + 1)) {
                    map.put(distance + 1, new TreeMap<Integer, List<Integer>>());
                }

                if (!map.get(distance + 1)
                        .containsKey(level + 1)) {
                    map.get(distance + 1)
                       .put(level + 1, new ArrayList<>());
                }

                map.get(distance + 1)
                   .get(level + 1)
                   .add(node.right.val);
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        for (Integer key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for (Integer l : map.get(key)
                                .keySet()) {
                List<Integer> list = (map.get(key)
                                         .get(l));
                Collections.sort(list);
                temp.addAll(list);
            }
            result.add(temp);
        }
        return result;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<LevelVal>> map = new TreeMap<>();
        helper(map, root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<LevelVal>> entry : map.entrySet()) {
            List<LevelVal> list = entry.getValue();
            Collections.sort(list);
            res.add(list.stream()
                        .map(lv -> lv.val)
                        .collect(Collectors.toList()));
        }
        return res;
    }

    void helper(Map<Integer, List<LevelVal>> map, TreeNode node, int colNum, int level) {
        if (node == null) {
            return;
        }
        map.putIfAbsent(colNum, new ArrayList<>());
        map.get(colNum)
           .add(new LevelVal(level, node.val));
        helper(map, node.left, colNum - 1, level + 1);
        helper(map, node.right, colNum + 1, level + 1);
    }

    /**
     * as of 3/6 Runtime: 3 ms, faster than 76.21% of Java online submissions for Vertical Order Traversal of a Binary
     * Tree. Memory Usage: 39 MB, less than 89.69% of Java online submissions for Vertical Order Traversal of a Binary
     * Tree.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>(); // order by key
        helper2(root, 0, 0, map);

        for (int key : map.keySet()) {
            List<Integer> colList = new ArrayList<>();
            Map<Integer, List<Integer>> levelMap = map.get(key);
            for (int level : levelMap.keySet()) {
                List<Integer> lst = levelMap.get(level);
                Collections.sort(lst);
                colList.addAll(lst);
            }
            result.add(colList);
        }
        return result;
    }

    void helper2(TreeNode root, int row, int col, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(col, new TreeMap<Integer, List<Integer>>());
        map.get(col)
           .putIfAbsent(row, new ArrayList<Integer>());
        map.get(col)
           .get(row)
           .add(root.val);
        helper2(root.left, row + 1, col - 1, map);
        helper2(root.right, row + 1, col + 1, map);
    }
}


class LevelVal implements Comparable<LevelVal> {

    int val;
    int level;

    LevelVal(int level, int val) {
        this.level = level;
        this.val = val;
    }

    @Override
    public int compareTo(LevelVal other) {
        int ret = this.level - other.level;
        if (ret != 0) {
            return ret;
        }
        return this.val < other.val ? -1 : 1;
    }
}
