package com.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.practice.tree.TreeNode;

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

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
}
