class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    
   public List<List<Integer>> subsetsWithDup(int[] nums) {
         
       Arrays.sort(nums);
       res.add(new ArrayList<>());
       int startIndex=0;
       int endIndex=0;
        for(int i=0; i < nums.length;i++){
            startIndex=0;
            if(i > 0 && nums[i]==nums[i-1])
                startIndex = endIndex+1;
            endIndex = res.size()-1;
            for(int j= startIndex; j <= endIndex; j++){
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }            
        } 
       
        return res;
    }
    
    
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
         
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