class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
           
        Map<Integer,Integer> inDegree = new HashMap<>();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        // Initialize the graph 
        for(int i =0; i < numCourses; i++){
            inDegree.put(i,0);
            graph.put(i,new ArrayList<>());
        }
        
        // build the graph 
        for(int [] pre : prerequisites){
            int parent = pre[1]; int child = pre[0];
            graph.get(parent).add(child);
            inDegree.put(child,inDegree.get(child)+1);
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        // find all the sources
        for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
            if(entry.getValue()==0)
                queue.add(entry.getKey());
        }
        List<Integer> sortedOrder = new ArrayList<>();
        // create sequence from the sources 
        while(!queue.isEmpty()){
            int source = queue.poll();
            sortedOrder.add(source);
          
            for( int child: graph.get(source)){
                inDegree.put(child,inDegree.get(child)-1);
                if(inDegree.get(child)==0)
                    queue.add(child);
            }
        }
        
        if(sortedOrder.size()!=numCourses)
            return new int[0];
        
        int [] order = new int[numCourses];
        int k=0;
        for(int item : sortedOrder)
            order[k++] = item;
        
        return order;
    }
}