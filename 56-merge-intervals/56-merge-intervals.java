class Solution {
    public int[][] merge(int[][] intervals) {
        
         LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
     
        for(int [] interval : intervals){
           
            if(list.isEmpty() || interval[0] >  list.peekLast()[1] ){
                 list.add(interval);
                 
            }else{
                list.peekLast()[1] = Math.max(list.peekLast()[1], interval[1]);
            }
        }
        
        int [][] ret = new int[list.size()][2];
        int i=0;
        for(int [] item : list){
            ret[i++]=item;
        }
       return ret;
    }
}