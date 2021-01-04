package com.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOfTreesForGolfEvent {

    public int cutOffTree(List<List<Integer>> forest) {

        if (forest == null || forest.size() == 0) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // order the trees based on height
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0)
                                      .size(); j++) {
                if (forest.get(i)
                          .get(j) > 0) {
                    pq.offer(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        // start to 1st smallest tree height
        int[] start = new int[]{0, 0};
        int step = 0;
        int totalStep = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int[] dest = new int[]{tree[0], tree[1]};
            step = minStep(start, dest, forest);// go from start to dest
            if (step < 0) {
                return -1;
            }
            totalStep += step;
            start = dest;

        }
        return totalStep;
    }

    int minStep(int[] start, int[] dest, List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0)
                      .size();
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == dest[0] && curr[1] == dest[1]) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || forest.get(r)
                                                                                     .get(c) == 0) {
                        continue;
                    }

                    visited[r][c] = true;
                    queue.add(new int[]{r, c});
                }
            }
            steps = steps + 1;
        }
        return -1;
    }

}
