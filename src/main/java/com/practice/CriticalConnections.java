package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {

    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        int[] low = new int[n];
        List<Integer>[] graph = new ArrayList[n];

        // build graph

        // build array of lists
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // add edges
        for (List<Integer> edge : connections) {

            int from = edge.get(0);
            int to = edge.get(1);

            graph[from].add(to);
            graph[to].add(from);
        }

        // dfs on unvisited nodes
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(graph, i, disc, low, result, i);
            }
        }

        return result;

    }

    void dfs(List<Integer>[] graph, int u, int[] disc, int[] low, List<List<Integer>> result, int parent) {

        disc[u] = low[u] = ++time;

        for (int v : graph[u]) {

            if (v == parent) {
                continue;
            }

            if (disc[v] == -1) { // if not discovered
                dfs(graph, v, disc, low, result, u);
                low[u] = Math.min(low[v], low[u]);
                if (low[v] > disc[u]) { // critical connection
                    result.add(Arrays.asList(u, v));
                }
            } else { // if already discovered
                low[u] = Math.min(low[u], disc[v]);
            }

        }

    }
}
