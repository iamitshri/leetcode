class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();
        
        String [][] map = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        List<String> res = new ArrayList<>();
        helper(map,digits,new StringBuilder(),res,0);
        return res;
    }
    
    void helper(String [][] map, String digits, StringBuilder str, List<String> res, int start){
        
        if(str.length()==digits.length()){
            res.add(str.toString());
            return;
        }
        
         for(int i=start;i < digits.length();i++){
             int num = digits.charAt(i)-'0';
             for(String c : map[num]){
                 str.append(c);
                 helper(map,digits,str,res, i+1);
                 str.setLength(str.length()-1);
             }
         }
        
    }
}