class Solution {
    public int longestPalindrome(String s) {
        
        int [] count = new int[128];
        for(char c : s.toCharArray()){
            count[c]++;
        }
        int ans=0;
        for(int c : count){
            ans += (c/2)*2;
            
            if(ans%2==0 && c%2==1)
                ans+=1;
        }
        return ans;
    }
}