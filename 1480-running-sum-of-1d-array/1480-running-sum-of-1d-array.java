class Solution {
    public int[] runningSum(int[] nums) {
        int prefixSum = 0 ; 
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            nums[i] = prefixSum;
        }
            
        return nums;
    }
}