class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
                   
        helper(new ArrayList<>(),0,nums);
        return result;
    }
    
    void helper(List<Integer> list, int index, int [] nums){
        
        result.add(new ArrayList<>(list));
        
        for(int i=index; i < nums.length;i++){
            list.add(nums[i]);
            helper(list, i+1, nums);
            list.remove(list.size()-1);
        }
        
    }
    
    
}