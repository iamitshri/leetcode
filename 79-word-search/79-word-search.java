class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i < board.length;i++){
            for(int j=0; j < board[0].length;j++){
                if(explore(board,word,i,j,0)){
                  return true;
                }
            }
        }
        return false;
    }
    
    boolean explore( char[][] board, String word, int i, int j, int wordIndex){
        
        if(wordIndex==word.length())
            return true;
        
        if( i < 0 || i == board.length || j < 0 || j == board[0].length)
            return false;
        
        
        
        if( board[i][j]!=word.charAt(wordIndex) || board[i][j]=='#'){
             return false;
         }
        
        char c = board[i][j];
        board[i][j] = '#';
        int[][]dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int [] dir: dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            boolean res = explore(board,word,x,y,wordIndex+1);
            if(res) return true;
        }
        board[i][j] = c;
        return false;
    }
}