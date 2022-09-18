class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
   public List<List<Integer>> subsets(int[] nums) {
        
       List<Integer> currentList = new ArrayList<>(); // start with empty list
       result.add(currentList);
        for(int n: nums){
            int size = result.size();
            for(int i=0; i < size;i++){
                List<Integer> l = result.get(i);
                List<Integer> newList = new ArrayList<>(l);
                newList.add(n);
                result.add(newList);
            }
        }
       return result;
    }
    
    
    public List<List<Integer>> subsets2(int[] nums) {
                   
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