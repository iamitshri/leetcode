class Solution {
    public boolean isPalindrome(String s) {
        // if s is empty return true
        
        //convert to lowercase remove non alphanumeric chars
        
        if("".equals(s))
            return true;
        
        if(s.length()==1)
            return true;
        
        int i=0; 
        int j=s.length()-1;
        //"    i    "
        while(i < j){
            
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            
            while(j > 0  && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            
            if(i< s.length() && j > 0 && Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
                return false;
            
            i++;
            j--;
        }
        
        return true;
        
    }
}