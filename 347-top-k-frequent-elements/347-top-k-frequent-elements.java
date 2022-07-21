class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
           map.put(n, map.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.getValue(),b.getValue()));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }
        
        int [] ret = new int[k];
        int r=0;
        while(!pq.isEmpty()){
            ret[r++] = pq.poll().getKey();
        }
        return ret;
    }
}