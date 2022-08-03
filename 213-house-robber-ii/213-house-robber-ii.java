class Solution {
    public int rob(int[] nums) {
     
        if(nums.length==1)
            return nums[0];
        
     int n1=  rob(nums,1,nums.length-1);
     int n2=  rob(nums,0,nums.length-2);
        
        return Math.max(n1,n2);
        
    }
    
    int rob(int [] nums, int start, int end){
        
        int oneBack=0;
        int twoBack=0;
        
        for(int i=start; i<=end;i++){
            
            int temp = oneBack;
            oneBack = Math.max(nums[i]+twoBack, oneBack);
            twoBack = temp;
        }
        
        return oneBack;
    }
}