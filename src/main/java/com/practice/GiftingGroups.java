package com.practice;

public class GiftingGroups {


    public int findCircleNum(int[][] M) {

        if (M == null || M.length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(M.length);
        int cols = M[0].length;
        int rows = M.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.numComponents;
    }

    class UnionFind {

        int numComponents;
        int parent[];

        UnionFind(int N) {
            numComponents = N;
            parent = new int[N];

            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

        }

        int find(int q) {
            int p = q;
            while (parent[p] != p) {
                p = parent[p];
            }
            // p is parent of q now
            while (p != q) {
                int n = parent[q];
                parent[q] = p;
                q = n;
            }
            return p;
        }

        void union(int q1, int q2) {
            int p1 = find(q1);
            int p2 = find(q2);

            if (p1 == p2) {
                return;
            }

            parent[p1] = p2;
            this.numComponents--;
        }
    }

}
