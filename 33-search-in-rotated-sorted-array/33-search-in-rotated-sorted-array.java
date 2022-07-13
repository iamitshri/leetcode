class Solution {
    public int search(int[] nums, int target) {
        
        int l=0; int h=nums.length-1;
        while(l <= h){
            
            int m = (h-l)/2+l;
            if(nums[m]==target)
                return m;
            
            if(nums[l] <= nums[m]){
                if(target >= nums[l] && target < nums[m])
                    h = m - 1;
                else
                    l = m + 1;
            }else{
                
                if(target > nums[m] && target <= nums[h])
                    l = m + 1;
                else 
                    h = m - 1;
            }
            
        }
        
        return -1;
        
    }
}