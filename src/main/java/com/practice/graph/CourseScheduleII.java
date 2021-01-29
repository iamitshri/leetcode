package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // build Graph
        Map<Integer, List<Integer>> g = new HashMap<>();
        Map<Integer, Integer> incoming = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            incoming.putIfAbsent(i, 0);
            g.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {

            int course = pre[0];
            int preReq = pre[1];
            g.get(course)
             .add(preReq);
            incoming.put(preReq, incoming.get(preReq) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : incoming.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<Integer> res = new LinkedList<>();

        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            res.add(0, course);
            for (int child : g.get(course)) {
                incoming.put(child, incoming.get(child) - 1);
                if (incoming.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[0];
        }

        return res.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
        // map of List
        // incoming edge
        // queue add nodes with zero incoming edges
        // process such node, reduce incoming edges on the children
        // everytime you take off something from queue add it to the ans
        // if
    }
}