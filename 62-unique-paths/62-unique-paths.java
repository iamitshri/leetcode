class Solution {
    
    
    public int uniquePaths(int m, int n) {
         
        int [][] dp = new int[m][n];
        for(int [] d : dp){
            Arrays.fill(d,1);
        }
        
        for(int i=1;i<m;i++){
         for(int j=1;j<n;j++){
             dp[i][j] = dp[i-1][j] + dp[i][j-1];
          }   
        }
        return dp[m-1][n-1];
    }
    
    
    // return helper(m-1,n-1, new Integer[m][n]);
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