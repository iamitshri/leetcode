package com.practice.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PerfectSquares {


    public int numSquares(int n) {
        // n-1 n-2 n-3 n-4 n-5
        // 5-
        // 1 4 9 16 25 36 49
        LinkedList<Integer> queue = new LinkedList<>();
        int num = 1;
        int level = 0;
        queue.add(n);

        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                n = queue.poll();
                num = 0;
                if (n == 0) {
                    return level;
                }
                while (n >= (num * num)) {
                    if (visited.add(n - (num * num))) {
                        queue.add(n - (num * num));
                    }
                    num++;
                }
            }

            level++;
        }

        return level;
    }

    public int numSquaresDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
