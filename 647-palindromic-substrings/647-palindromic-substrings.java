class Solution {
    
    public int countSubstrings(String s) {
        int result=0;
        
        for(int i=0;i< s.length();i++){
            result+= count(s,i,i);
                
            result+= count(s,i,i+1);
        }
        return result;
    }
    
    
    
    int count(String s, int l, int r){
        int ans=0;
        while(l>=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            ans++;
        }
        return ans;
    }
}