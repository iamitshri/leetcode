class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if( s.isEmpty())
            return true;
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=0;i <= n;i++){
            if(!dp[i]) continue;
             for(String w : wordDict){
                int j = i + w.length();
                if(j<=n && w.equals(s.substring(i,j))){
                    dp[j] = true;     
                 }
             }      
        }
        return dp[n];
    }
}