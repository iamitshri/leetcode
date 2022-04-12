class Solution {
    public int maxProfit(int[] prices) {
        //buy-sell twice 
        int min = prices[0];
        int profit=0;
        for(int i=0;i < prices.length;i++){
          min = Math.min(min, prices[i]);    
          if(prices[i] > min){
              profit+= prices[i]-min;
              min = prices[i];
          }
        }
        return profit; 
    }
}

// [2,1,5,3,2,55] 