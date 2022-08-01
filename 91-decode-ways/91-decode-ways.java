class Solution {
    public int numDecodings(String s) {
        
        Integer [] dp = new Integer[s.length()+1];
       return recursiveWithMemo(0,s,dp);
    }
    
    
    int recursiveWithMemo(int i, String s, Integer [] dp){
        
        if(i== s.length())
            return 1;
        
        if(s.charAt(i)== '0')
            return 0;
        
        if(i == s.length()-1)
            return 1; 
    
        
        if(dp[i]!=null)
            return dp[i];
        
        int ans = recursiveWithMemo(i+1,s,dp);
        int twoDigit= Integer.parseInt(s.substring(i,i+2));
        
        if(twoDigit >0 && twoDigit <= 26) 
            ans+= recursiveWithMemo(i+2,s,dp);
        
        dp[i]=ans;
        
        return dp[i];
    }
}