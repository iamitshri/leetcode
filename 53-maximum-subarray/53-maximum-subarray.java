class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        
        for(int i =0 ; i < nums.length;i++){
        // -2,1,-3,4,-1,2,1,-5,4
            sum += nums[i];
        // start a new sum or continue existing sum 
            if(nums[i] > sum )
                sum = nums[i];
            
            max = Math.max(max,sum);
        
        }
        
        return max;
        
    }
}