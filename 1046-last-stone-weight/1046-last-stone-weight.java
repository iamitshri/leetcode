
class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for( int n : stones){
            pq.add(n);
        }
        
        while(pq.size() > 1){
            int x = pq.poll();int y = pq.poll();
            if(x!=y){
                pq.add(Math.abs(y-x));
            }
        }
        
        return pq.size()==0 ? 0 : pq.poll();
    }
}