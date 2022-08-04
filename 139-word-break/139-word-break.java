class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if( s.isEmpty())
            return true;
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=1;i <= n;i++){
            if(!dp[i-1]) continue;
             for(String w : wordDict){
                int j = i-1 + w.length();
                if(j<=n && w.equals(s.substring(i-1,j))){
                    dp[j] = true;     
                 }
             }      
        }
        

        
        return dp[n];
    }
}