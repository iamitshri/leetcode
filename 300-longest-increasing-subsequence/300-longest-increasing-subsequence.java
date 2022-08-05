class Solution {
    
     /*
        //[10,9,2,5,3,7,101,18]
        10   1
         9   1 
         2   1
         5   2
         3   2
         7   3
         101 4
         18  4
          */
    public int lengthOfLIS(int[] nums) {
          int [] dp = new int [nums.length];
        int maxLen=1;
        dp[0]=1;
         for(int i=1;i < nums.length;i++){
             dp[i]=1;
             for(int j=0;j < i;j++){
                if(nums[i]>nums[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
                    maxLen = Math.max(maxLen,dp[i]);
                 }
            }
        }
         return maxLen;
    }
}