class Solution {
    
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,new ArrayList<>(),0);
        return res;
    }
    
    void helper(String s, List<String> list, int start){
        
        if(start == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=start ; i < s.length();i++){
            
            String str = s.substring(start,i+1);
            if(!isPalindrome(str)) continue;
            
            list.add(str);
            helper(s, list,i+1);
            list.remove(list.size()-1);
        }
    }
    
    boolean isPalindrome(String s){
        int l=0;int r=s.length()-1;
        
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;r--;
        }
        return true;
    }
}