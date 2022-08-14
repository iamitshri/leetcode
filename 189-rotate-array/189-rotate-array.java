class Solution {
    public void rotate(int[] nums, int k) {
        
        if(k >= nums.length){
            k = k%nums.length;
        }
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
    }
    
    void rev(int [] nums, int l, int r){
        if(l >= r)
            return;
        while(l < r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r]=t;
            l++;r--;
        }
        
    }
}