class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         
        Arrays.sort(nums);
        
        helper(nums,new ArrayList<>(),0);
        return res;
    }
    
    void helper(int[] nums, List<Integer> list, int start){
        
        res.add(new ArrayList<>(list));
        
        for(int i=start;i < nums.length;i++){
            
            if(i > start && nums[i] == nums[i-1]) continue;
            
            list.add(nums[i]);
            helper(nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
}