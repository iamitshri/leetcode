class Solution {
    public int maxProduct(int[] nums) {
           /*
           2*3=6
           2*3*-2= -12
           2*3*-2*4= -48
            
           3
           3*-2*4=-24
           3*-2=-6  
             -2
            -2*4=-8
            4=4
            */
        int maxproductsofar = nums[0];
        int minproductsofar = nums[0];
       
        int maxProduct=nums[0];
        // candidates = (A[i], imax * A[i], imin * A[i])
        for(int i=1;i < nums.length;i++){
            int temp = Math.max(nums[i],Math.max(maxproductsofar*nums[i], minproductsofar*nums[i]));
            minproductsofar = Math.min(nums[i],Math.min(maxproductsofar*nums[i], minproductsofar*nums[i]));
            maxproductsofar=temp;     
           maxProduct = Math.max(maxproductsofar, maxProduct);
        }
          return maxProduct;
    }
}