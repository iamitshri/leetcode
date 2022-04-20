class Solution {
    List<List<String>> list= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i < n;i++){
          for(int j=0; j < n;j++){
            board[i][j]='.';
          }   
        }
        
        helper(n,0,board);
        return list;
    }
    
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    
    public void helper(int n, int row,char[][] board ) {
        
        if(row==n){
            List<String> ll = new ArrayList<>();
            for(int i=0; i < n;i++){
              ll.add(new String(board[i]));
            }   
            list.add(ll);
            return;
        }
        for(int col=0; col < n ;col++){
            

            if(cols.contains(col) || diag1.contains(row+col) || diag2.contains(row-col)){
                continue;
            }
                
            cols.add(col); diag1.add(row+col); diag2.add(row-col);
            board[row][col]='Q';
            
            helper(n,row+1,board);
            
            // backtrack
            board[row][col]='.';
            cols.remove(col); diag1.remove(row+col); diag2.remove(row-col);
        }
    }
    
}