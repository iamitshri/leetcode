class Solution {
    int count=0;
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    Set<Integer> colSet = new HashSet<>();
   
    public int totalNQueens(int n) {
        // place a queen if it can not be attacked
        // check if  row is taken, 
        // check if col is taken 
        // check if diagonal is taken
        // 0,1
        helper(0,n);
        return count;
    }
      
    
    void helper(int row, int n){
        
        if(row==n){
            count++;return;
        }
            
        
        for(int col=0; col < n;col++){
            
            if(colSet.contains(col)){
                continue;
            }     
           
            if(diag1.contains(row+col)){
                continue;
            }
            if(diag2.contains(row-col)){
                continue;
            }
             
                colSet.add(col);
                diag1.add(row+col);
                diag2.add(row-col);
                
                helper(row+1, n);
                
                colSet.remove(col);
                diag1.remove(row+col);
                diag2.remove(row-col);
             
        }
    }
}