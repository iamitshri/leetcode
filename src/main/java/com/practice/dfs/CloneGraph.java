package com.practice.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return clone(node, new HashMap<>());
    }

    public Node clone(Node node, Map<Integer, Node> map) {

        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        for (Node n : node.neighbors) {
            if (!map.containsKey(n.val)) {
                Node cloned = clone(n, map);
                newNode.neighbors.add(cloned);
            } else {
                newNode.neighbors.add(map.get(n.val));
            }
        }
        return newNode;
    }
}
