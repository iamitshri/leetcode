class Solution {
 
    
       public int findMiddleIndex(int[] nums) {
     
        int [] prefix = new int[nums.length];
        prefix[0]=0;
        int prefixSum=0;
        for(int i =1;i<nums.length;i++){
             prefixSum += nums[i-1];
            prefix[i] = prefixSum;
        }
        int sum=0;
        int res=-1;
        for(int i=nums.length-1;i>=0;i--){
            
            if(prefix[i]==sum)
                res = i;
            
            sum += nums[i];
        }
        
        return res;
    }
}