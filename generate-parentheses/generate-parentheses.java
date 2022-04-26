class Solution {
    public List<String> generateParenthesis(int n) {
        
        generate(0,0,"",n);
        return list;
        
    }
    
    List<String> list = new ArrayList<>();
    
    void generate(int open, int close, String str, int n){
        
        if(open == close && open == n){
        list.add(str);
            return;
        }
        
        // choose 
            if(open < n){
                generate(open+1,close, str+"(",n);
            }
        
            if(close < open){
                generate(open,close+1, str+")",n);
            }
        // backtrack
        //unchoose
    }
}