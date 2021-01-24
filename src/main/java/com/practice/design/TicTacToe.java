package com.practice.design;

public class TicTacToe {

    int []rows ;
    int [] cols;
    int digo=0;
    int antidigo=0;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n=n;
        rows = new int[n];
        cols = new int[n];
        digo=0;
        antidigo=0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int sign = player==1 ? 1 : -1;
        int result = n * sign;
        rows[row]+=sign;
        cols[col]+=sign;
        if(row==col){
            digo+=sign;
        }
        if(row==n-1-col){
            antidigo+=sign;
        }
        if(rows[row]==result || cols[col]==result || digo==result ||antidigo==result ){
            return player;
        }
        return 0;
    }
}



/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

class TicTacToeBruteForce {

    int [][] board ;
    int n;
    /** Initialize your data structure here. */
    public TicTacToeBruteForce(int n) {
        this.n=n;
        board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        if (board[row][col] != 0) return 0; // cell is used
        board[row][col]=player;

        boolean matched=true;
        for(int i=0;i<n;i++){

            if(board[i][i]!=player){
                matched=false;
                break;
            }

        }
        if(matched){
            return player;
        }
        matched=true;
        for(int i=0;i<n;i++){

            if(board[i][n-1-i]!=player){
                matched=false;
                break;
            }

        }
        if(matched){
            return player;
        }



        boolean horizontal=true;
        for(int i =0 ; i < n ; i++){
            if(board[row][i]!=player){
                horizontal=false;
                break;
            }
        }
        if(horizontal){return player;}

        boolean vertical=true;
        for(int i =0 ; i < n ; i++){
            if(board[i][col]!=player){
                vertical=false;
                break;
            }
        }
        if(vertical){return player;}

        return 0;
    }
}