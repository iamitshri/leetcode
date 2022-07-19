class Solution {
    
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,new ArrayList<>());
        return res;
    }
    
    void helper(String s, List<String> list){
        
        if(s==null || s.length()==0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=1 ; i <= s.length();i++){
            
            String str = s.substring(0,i);
            if(!isPalindrome(str)) continue;
            
            list.add(str);
            helper(s.substring(i,s.length()), list);
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