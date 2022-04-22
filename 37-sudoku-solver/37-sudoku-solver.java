class Solution {
    
    int n = 3 ; // box size 
    
    int N = n * n ; 
    
    int [][]rows = new int[N][N+1];
    int [][]cols = new int[N][N+1];
    int [][]boxes = new int[N][N+1];
    
    char[][] board;
    
    void placeNumber(int d, int i, int j){
        
        rows[i][d]=d;
        cols[j][d]=d;
        int idx = (i/n)*n+(j/n);
        boxes[idx][d]=d;
        board[i][j]=(char)('0'+d);
        
    }
    
     void removePlacement(int d,int i,int j){
        rows[i][d]=0;
        cols[j][d]=0;
        int idx = (i/n)*n+(j/n);
        boxes[idx][d]=0;
        board[i][j]='.';
    }
    
    boolean isSudokuSolved=false;
    
    void placeNextNumbers(int i, int j){
        if(j==N-1 && i==N-1 ){
            isSudokuSolved=true;
            return;
        }
         if(j==N-1){
            backtrack(i+1,0);
          }else{
             backtrack(i,j+1);
         }
    }
    
   
    boolean canPlace(int d, int i, int j){
        
        int idx = ((i/n)*n)+(j/n);
        return 0 == rows[i][d] + cols[j][d] + boxes[idx][d];
    }
    
    
    public void solveSudoku(char[][] board) {
        
        this.board=board;
        for(int i=0;i< N;i++){
            for(int j=0;j< N;j++){
                char num = board[i][j];
                if(num!='.'){
                    int d = Character.getNumericValue(num);
                    placeNumber(d,i,j);
                }
            }
        }
        backtrack(0,0);
    }
    
    void backtrack(int i, int j){
        
        if(board[i][j]=='.'){
            for(int d=1;d < 10;d++){
                if(canPlace(d,i,j)){
                    placeNumber(d,i,j);
                    placeNextNumbers(i,j);
                    if(isSudokuSolved)
                        break;
                    removePlacement(d,i,j);
                }
            }
        }else{
            placeNextNumbers(i,j);
        }
    }
    
    
}