package com.practice.tree;

public class AllNodesDistanceKBinaryTree {
    public java.util.List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        java.util.Map<Integer, java.util.HashSet<Integer>> map = new java.util.HashMap<>();
        buildMap(root,null,map);
        java.util.Set<Integer> visited = new java.util.HashSet<>();
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        visited.add(target.val);
        queue.add(target.val);
        while(!queue.isEmpty() && k > 0){
            int size = queue.size();
            for(int i=0; i < size;i++){
                int v = queue.poll();

                for(int c : map.get(v)){
                    if(!visited.contains(c)){
                        queue.offer(c);
                        visited.add(c);
                    }
                }
            }
            k--;
        }
        java.util.List<Integer> res = new java.util.ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }



    void buildMap(TreeNode root, TreeNode parent, java.util.Map<Integer, java.util.HashSet<Integer>> map){

        if(root==null)
            return;
        int v = root.val;

        map.putIfAbsent(v,new java.util.HashSet<>());
        if(parent!=null) map.get(v).add(parent.val);
        if(root.left!=null) map.get(v).add(root.left.val);
        if(root.right!=null) map.get(v).add(root.right.val);

        buildMap(root.left,root,map);
        buildMap(root.right,root,map);
    }
}
