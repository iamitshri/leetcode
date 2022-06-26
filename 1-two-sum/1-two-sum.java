class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if(nums==null || nums.length==0)
            return new int[0];
        
        Map<Integer,Integer> map = new HashMap<>();
        // 2 7 11 15 t=9 
        for(int i=0;i<nums.length;i++){
            // iterate and check if target-current is present in the map 
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            } 
                map.put(nums[i],i);
            
        }
        
        return new int[0];
    }
}