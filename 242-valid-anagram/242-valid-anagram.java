class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length()) return false;
        
        int [] store = new int[26];
        for(int i=0; i < s.length() ;i++){
           store[s.charAt(i)-'a']++;
           store[t.charAt(i)-'a']--;
        }
        
        for(char c : s.toCharArray()){
            if(store[c - 'a'] !=0)
                return false;
        }
        return true;
    }
    
      public boolean isAnagram1(String s, String t) {
        //  both are equal true
        //  length not matching false
            // sort the word and check
        char [] s1 = s.toCharArray(); Arrays.sort(s1); //n1logn1
        char [] t1 = t.toCharArray(); Arrays.sort(t1); //n2logn2
        
        return new String(s1).equals(new String(t1));
    }
}