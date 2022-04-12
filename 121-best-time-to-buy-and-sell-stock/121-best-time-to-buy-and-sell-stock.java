class Solution {
    public int maxProfit(int[] prices) {
        
        int min=prices[0];
        int diff=0;
        for(int i=0;i< prices.length;i++){
            min = Math.min(prices[i],min);
            diff = Math.max(diff,prices[i]-min);
        }
        
        return diff;
    }
}