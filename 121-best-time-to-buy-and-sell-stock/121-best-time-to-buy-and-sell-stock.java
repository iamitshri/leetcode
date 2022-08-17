class Solution {
    
    public int maxProfit(int[] prices) {
    int max=0;
    int min=Integer.MAX_VALUE;
        
        for(int i=0; i < prices.length;i++){
            min = Math.min(min, prices[i]);
            int profit = prices[i] - min;
            max= Math.max(max,profit);
        }
          return max;
    }
    
  
}