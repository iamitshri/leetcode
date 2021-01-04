package com.practice;

import java.util.PriorityQueue;

public class KclosestElements {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for (int[] point : points) {

            int distance = (point[1] * point[1]) + (point[0] * point[0]);
            pq.add(new int[]{point[0], point[1], distance});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] r = pq.poll();
            result[cnt][0] = (int) r[0];
            result[cnt][1] = (int) r[1];
            cnt++;
        }
        return result;
    }
}
