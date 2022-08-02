class Solution {
    
    
    public int uniquePaths(int m, int n) {
         return helper(m-1,n-1, new Integer[m][n]);
    }
    
    
    int helper(int m, int n, Integer[][]  dp){
        
        if(m ==0)
            return 1;
        if(n==0)
            return 1;
        
        if(m < 0 || n < 0)
            return 0;
        
       if(dp[m][n]!=null)
           return dp[m][n];
        
        dp[m][n] =  helper(m-1,n,dp) + helper(m,n-1,dp);
        return dp[m][n];
        
    }
}