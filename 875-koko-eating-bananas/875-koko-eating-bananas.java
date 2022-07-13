class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      
        int left=1;
        int right=1;
        
        for(int pile:piles)
            right = Math.max(right,pile);
        
        while(left<right){
            
            int mid = (left+right)/2;
            
            int hrSpent=0;
            
            for(int pile:piles){
                hrSpent+= Math.ceil((double)pile/mid);
            }
            
            if(hrSpent<=h){
                right = mid;
            }else{
                left = mid+1;
            }
            
        }
        
        return right;
        
        
    }
}