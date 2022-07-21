class Solution {
    public int missingNumber(int[] nums) {
     
        int res=0;
        // 0 3 1    0 1 2 3 
        // 2 1 0    0 1 2
        for(int i=0; i <= nums.length;i++){
            res ^=  i ;
        }
        
        for(int i=0; i < nums.length;i++){
            res ^=  nums[i];
        }
        
        return res;
    }
}