class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        // generate balanced parentheses
        helper("",result,n, 0,0);
        return result;
    }
    
    void helper(String str, List<String> result, int n, int open, int close ){
        
        // generate 
        if(n*2 == str.length()){
            result.add(str);
            return;
        }
        
        if(open < n){
            helper( str+"(", result,n,open+1,close);
        }
        
        if(close < open){
            helper(str+")",result,n,open,close+1);
        }
        
        
    }
}