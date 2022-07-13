class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // kthe largest element in the array 
        // keep track of k largest elements 
        // smallest at the top minHeap 
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : nums){
            // 3 2 3 1 2 4 5 5 6 
            // 5 5 6 4
             minHeap.offer(n);
             if(minHeap.size()>k){
                 // remove the smallest 
                 minHeap.poll();
             }
        }
        return minHeap.peek();
    }
}