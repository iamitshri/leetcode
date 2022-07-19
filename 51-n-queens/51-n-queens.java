class Solution {
    
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        helper(0,n,new ArrayList<>());
        return result;
    }
    
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    
    void helper(int row, int n, List<String> list){
        
         
        if(row==n){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int col=0; col < n;col++){
            
            if(cols.contains(col) || diag1.contains(row+col) || diag2.contains(row-col))
                continue;
            
            char [] columns = new char[n];
            Arrays.fill(columns,'.');
            columns[col]='Q';
            
            cols.add(col);
            diag1.add(row+col);
            diag2.add(row-col);
            String x = new String(columns);
           
            list.add(x);
            
            helper(row+1,n,list);
            
            list.remove(list.size()-1);
            cols.remove(col);
            diag1.remove(row+col);
            diag2.remove(row-col);
        }
        
    }
     
}