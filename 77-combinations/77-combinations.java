class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // create combination from n using k 
        List<Integer> list = new ArrayList<>();
        helper(1,n,k,list);
        return lists;    
    }
    List<List<Integer>> lists = new ArrayList<>();
    void helper(int start, int n, int k, List<Integer> list){
        
        if(list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
         }   
         for(int i= start;i <= n;i++){
            list.add(i);    
            helper(i+1,n,k,list);    
            list.remove(list.size()-1);
        }
    }
}