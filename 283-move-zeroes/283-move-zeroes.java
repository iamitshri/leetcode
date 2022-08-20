class Solution {
    public void moveZeroes(int[] nums) {
        int slow=0;
        int i =0;
        while(i < nums.length){
            if(nums[i]!=0){
                nums[slow++]=nums[i];
            }
            i++;
        }
        
        while(slow < nums.length){
            nums[slow++]=0;
        }
    }
}