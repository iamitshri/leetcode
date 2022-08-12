class Solution {
 
    
       public int findMiddleIndex(int[] nums) {
        
        int total=0;
        for(int i =0;i<nums.length;i++){
             total+=nums[i];
        }
        int leftSum=0;
         for(int i =0;i<nums.length;i++){
            if(leftSum*2 == (total-nums[i])){
                 return i;
             }
               leftSum += nums[i];
        }
        
        return -1;
    }
}