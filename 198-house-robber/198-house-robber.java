class Solution {
    public int rob(int[] nums) {
        
        int oneBack=0;
        int twoBack=0;
        
        for(int i=0;i < nums.length;i++ ){
            int temp = oneBack;
            oneBack = Math.max(nums[i]+twoBack, oneBack);
            twoBack = temp;
        }
        
        return oneBack;
    }
    
    public int robDp(int[] nums) {
        
        int [] dp = new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        
        for(int i=2;i < dp.length;i++ ){
            dp[i] = Math.max(nums[i-1]+dp[i-2], dp[i-1]);
        }
        
        return dp[nums.length];
    }
}