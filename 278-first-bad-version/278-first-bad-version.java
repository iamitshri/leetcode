/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1;
        int right=n;
        int runner = n;
        int prev=1;
        while(!isBadVersion(runner)){
            prev = runner;
            runner = 2 * runner;
        }
        left= prev;
        right = runner;
        while(left<=right){
            int m = (right-left)/2+left; 
            
            if(isBadVersion(m)){
                right = m-1;
            }else{
                left = m + 1;
            }
        }
        // g g b b 
        return left;
    }
}