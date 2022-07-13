class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // o(m*n)
        // o(n * log(m))
        // o(log(mn))
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int l=0; int h = (rows*cols)-1;
        while(l <= h){
            int m = (h-l)/2+l;
            int mid = matrix[m/cols][m%cols];
            if(mid==target){
                return true;
            }else if(mid > target){
                h = m - 1;
            }else{
                l = m + 1;
            }
        }
        return false;       
    }
}