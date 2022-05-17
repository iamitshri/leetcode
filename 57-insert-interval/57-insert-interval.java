class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
     List<int[]> mergedIntervals = new ArrayList<>();
     // go over list of intervals
     // If new interval's start time is greater 
     LinkedList<int[]> list = new LinkedList<>();
     boolean inserted=false;
    for(int[] interval : intervals){
        
      if(newInterval[0] > interval[1]){
        list.add(interval);
        continue;
      }
        //1,2  3,4,  5,6
     if(!inserted && newInterval[1] < interval[0]){
          list.add(newInterval);
         inserted=true;
      }
        
      if(!inserted){
        interval[0] = Math.min(interval[0], newInterval[0]); 
        interval[1] =   Math.max(interval[1], newInterval[1]);
        list.add(interval);
        inserted=true;
      }
      // 3 12  9,12  
      if(list.isEmpty() || interval[0] > list.peekLast()[1]){
        list.add(interval);
      }else{
        list.peekLast()[1] = Math.max(list.peekLast()[1],interval[1]);
      }
    }
        if(list.isEmpty() || !inserted){
            list.add(newInterval);
        }
        int[][] result = new int[list.size()][2];
        int i=0;
        while(!list.isEmpty()){
            result[i++]=list.poll();
        }
    return result;
    }
}