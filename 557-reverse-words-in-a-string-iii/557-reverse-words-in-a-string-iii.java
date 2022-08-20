class Solution {
    public String reverseWords(String s) {
        
        int sp=0;
        char [] ch = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(ch[i]==' '){
                reverseString(ch, sp,i-1 );
                sp=i+1;
            }    
            if(i==s.length()-1){
                reverseString(ch, sp,s.length()-1);
            }
        }
         
        return new String(ch);
    }
    
     public void reverseString(char[] s, int l, int r) {
        
         
        while(l<r){
//             while(l < r && !Character.isLetter(s[l])){
//                 l++;
//             }   
            
//             while(l < r && !Character.isLetter(s[r])){
//                 r--;
//             }   
            
            if(l < r){
            char t = s[l];
            s[l] = s[r];
            s[r]=t;
            l++;r--;
            }
        }
    }
}