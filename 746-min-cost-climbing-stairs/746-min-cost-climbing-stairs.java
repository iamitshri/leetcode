class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
      return helper(0,cost);
    }
    
      private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    int helper(int i, int [] cost){
       
        if(i > cost.length-2){
            return 0;
        }
        
          if (memo.containsKey(i)) {
            return memo.get(i);
        }

        
         int ith = cost[i]+helper( i+1,cost);
         int iplus1=cost[i+1]+helper( i+2,cost);
             memo.put(i, Math.min(ith,iplus1));
        return memo.get(i); 
    }
}