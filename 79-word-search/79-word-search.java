class Solution {
    public boolean exist(char[][] board, String word) {
        
        
        for(int i=0; i < board.length;i++){
            for(int j=0; j < board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    if(word.length()==1)
                        return true;
                    boolean[][] used = new boolean[board.length][board[0].length];
                    boolean found = explore(used,board,word,i,j,0);
                    if(found)
                        return true;
                }
            }
        }
        return false;
    }
    
    boolean explore(boolean[][] used,char[][] board, String word, int i, int j, int wordIndex){
        
        if(wordIndex==word.length())
            return true;
        
         if( wordIndex==word.length()-1 && board[i][j]==word.charAt(wordIndex)){
             return true;
         }
        
        if( i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1)
            return false;
        
        if( board[i][j]==word.charAt(wordIndex)){
            used[i][j] = true;
            int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
            for(int [] dir: dirs){
                int x = i + dir[0];
                int y = j + dir[1];
                
                if( x < 0 || x > board.length-1 || y < 0 || y > board[0].length-1) continue;
                
                if(used[x][y]) continue;
                used[x][y]=true;
                if(explore(used,board,word,x,y,wordIndex+1)) return true;
                used[x][y]=false;
            }
             used[i][j] = false;
        }
        return false;
    }
}