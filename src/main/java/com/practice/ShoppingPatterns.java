package com.practice;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ShoppingPatterns {

    /**
     * https://www.youtube.com/watch?v=EdJhwAhVFXY&feature=youtu.be&ab_channel=TheWonderSeven-Zachry%27s
     *
     * @param products_nodes
     * @param products_edges
     * @param products_from
     * @param products_to
     * @return
     */
    public static int getMinScore(int products_nodes, int products_edges, int[] products_from, int[] products_to) {

        // Graph is an array of hash sets
        Set<Integer>[] graph = new HashSet[products_nodes + 1];
        for (int i = 1; i <= products_nodes; i++) {
            graph[i] = new HashSet<Integer>();
        }
        // Create Graph
        for (int i = 0; i < products_edges; i++) {
            int from = products_from[i];
            int to = products_to[i];
            graph[from].add(to);
            graph[to].add(from);
        }

        int result = Integer.MAX_VALUE;
        // Go over each product node
        for (int i = 1; i <= products_nodes; i++) {
            // get the neighbors
            Set<Integer> children = graph[i];
            // conver set to list of neighbors
            ArrayList<Integer> list = new ArrayList<>(children);

            for (int j = 0; j < list.size(); j++) {
                int p = list.get(j);
                for (int k = j + 1; k < list.size(); k++) {
                    int q = list.get(k);
                    if (graph[q].contains(p)) {
                        int min = graph[i].size() + graph[p].size() + graph[q].size() - 6;
                        result = Math.min(result, min);
                    }
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int products_nodes = Integer.parseInt(scanner.nextLine());
        int products_edges = Integer.parseInt(scanner.nextLine());
        int[] products_from = Arrays.stream(scanner.nextLine()
                                                   .split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
        int[] products_to = Arrays.stream(scanner.nextLine()
                                                 .split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
        scanner.close();
        System.out.println("Answer:-->"+getMinScore(products_nodes, products_edges, products_from, products_to));
    }

}
