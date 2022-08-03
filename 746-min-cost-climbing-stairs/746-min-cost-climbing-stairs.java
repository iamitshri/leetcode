class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length+1];
        
        dp[0]=0;
        dp[1]=0;
        // [ 1,2,3]  
        //[0, 0,2, 2,1]
        for(int i=2; i < dp.length; i++){
            int onestep = dp[i-1] + cost[i-1];
            int twostep = cost[i-2]+ dp[i-2];
            dp[i] = Math.min(onestep,twostep);
        }
        return dp[cost.length];
    }
    
    //return helper(0,cost);
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