class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    
    void helper(int[] candidates, int target, List<Integer> list, int sum, int start){
        
        if(target==sum){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = start;i < candidates.length;i++){
            
            if(i > start && candidates[i]==candidates[i-1]) continue;
                
            if(sum+candidates[i] > target) continue;
            
            list.add(candidates[i]);
            helper(candidates,target,list,sum+candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}