class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int prefix[] = new int[nums.length];
        prefix[0]=1;
        for(int i=1; i < nums.length;i++){        
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        
        int prev = 1;
        for(int i=nums.length-1;i>=0;i--){            
            int temp = nums[i];
            nums[i] = prev * prefix[i];
            prev *= temp;                
        }
        return nums;
        
        // 1 2 3 4 
        // 1 1 2 6   
        //   12  8  6 
    }
}