class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        
        for(int k=1; k < numRows;k++){
            list =  result.get(k-1);
            List<Integer> newlist = new ArrayList<>();
            newlist.add(1);
            for(int i=1; i < list.size() ;i++){
                newlist.add(list.get(i) + list.get(i-1));
            }
            newlist.add(1);
            result.add(newlist);
        }
        
        return result;
    }
}