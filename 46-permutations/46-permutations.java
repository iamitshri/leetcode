class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean [] used ;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        helper(nums,new ArrayList<>(),used);
        return res;
    }
    
    void helper(int[] nums, List<Integer> list, boolean[] used){
        if(list.size()== nums.length){
            res.add(new ArrayList<>(list));
         }
        
        for(int i= 0; i < nums.length;i++){
            if(used[i]) continue;
            
            used[i]=true;
            list.add(nums[i]);
            helper(nums,list,used);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}