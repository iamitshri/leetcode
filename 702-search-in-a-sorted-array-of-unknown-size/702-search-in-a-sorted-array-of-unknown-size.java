/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int start=0;int end=1;
      
        while( reader.get(end) < target){
            int newStart = end + 1; 
            end += (end-start+1)*2;
            start = newStart;
        }
        
        while(start <= end){
            int m = (end-start)/2+start;
            if(reader.get(m)==target)
                return m;
            else if(reader.get(m) > target){
                end = m - 1;
            }else
                start = m + 1;
        }
        
        return -1;
    }
}