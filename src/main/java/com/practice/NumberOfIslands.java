package com.practice;

import java.util.LinkedList;

public class NumberOfIslands {

    /**
     * https://leetcode.com/problems/number-of-islands/discuss/56354/1D-Union-Find-Java-solution-easily-generalized-to-other-problems
     * https://leetcode.com/problems/number-of-islands/discuss/722374/Using-union-find
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int numOfComponents = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numOfComponents++;
                }
            }
        }

        UnionFind unionfind = new UnionFind(m * n, numOfComponents);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionfind.union(i * m + j, (i - 1) * m + j);
                    }

                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionfind.union(i * m + j, i * m + (j - 1));
                    }
                }
            }
        }
        return unionfind.numComponents;
    }
}

class UnionFind {

    int[] parent;
    int[] size;
    int numComponents;
    int total;

    UnionFind(int N, int numOfComponents) {
        this.total = N;
        this.numComponents = numOfComponents;
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int p) {
        int root = p;
        // find with path compression
        while (root != parent[root]) {
            root = parent[root];
        }
        // path compression
        while (root != p) {
            int n = parent[p];
            parent[n] = root;
            p = n;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    void union(int p1, int p2) {

        if (connected(p1, p2)) {
            return;
        }

        int parent1 = find(p1);
        int parent2 = find(p2);
        if (size[parent1] > size[parent2]) {
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        } else {
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        }

        numComponents--;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void bfs(char[][] grid, int x2, int y2) {

        grid[x2][y2] = '0';
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        LinkedList<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        queue.add(x2 * n + y2);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int x = num / n;
            int y = num % n;

            for (int[] dir : dirs) {
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == '1') {
                    grid[x1][y1] = '0';
                    queue.add(x1 * n + y1);
                }
            }
        }

    }

}
