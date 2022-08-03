class Solution {
    public String longestPalindrome(String s) {
        
        
        if(s==null )
            return s;
        
        int end=0; int start=0;
        for(int i=0;i < s.length();i++){
            int oddlen = expand(s,i,i);
            int evenlen = expand(s,i,i+1);
            int len = Math.max(oddlen,evenlen);
            if(len > (end-start)){
                start = i - (len-1)/2;
                end = i + (len/2);
            }   
        }
        return s.substring(start,end + 1);
    }
    
    
     int expand(String s, int left, int right){
         
         if(s==null || left > right) return 0;
         
         while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
             left--;
             right++;
         }
         
         return (right-1)-(left+1)+1;
     }
    
}