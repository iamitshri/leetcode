class Solution {
    public int numDecodings(String s) {
        
        int [] dp = new int[s.length()+1];
        
        if(s.charAt(0)=='0')
            return 0;
        
        dp[0]=1;
        dp[1]= 1;
        for(int i=2; i < dp.length ;i++){
            
            if(s.charAt(i-1)!='0')
                dp[i] = dp[i-1];
            
            int td = Integer.parseInt(s.substring(i-2,i));
            if(td>=10 && td<=26){
                dp[i]+= dp[i-2];
            }
        }
            
        return dp[s.length()];
     //  return recursiveWithMemo(0,s,dp);
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