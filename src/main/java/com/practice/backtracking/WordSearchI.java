package com.practice.backtracking;

public class WordSearchI {

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    boolean dfs(char[][] board, String word, int start, int x, int y, boolean[][] visited) {

        if (start == word.length()) {
            return true;
        }

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) {
            return false;
        }

        visited[x][y] = true;
        if (word.charAt(start) == board[x][y]) {

            for (int[] dir : dirs) {

                boolean result = dfs(board, word, start + 1, x + dir[0], y + dir[1], visited);
                if (result) {
                    return true;
                }

            }
        }
        visited[x][y] = false;
        return false;

    }

    boolean dfsModifyInputArrayInsteadOfVisitedArray(char[][] board, String word, int start, int x, int y ){

        if(start==word.length()){
            return true;
        }

        if( x < 0 || y <0 || x >= board.length || y >= board[0].length || word.charAt(start)!=board[x][y])
            return false;
        board[x][y]='*';
        for(int [] dir : dirs){
            boolean result = dfsModifyInputArrayInsteadOfVisitedArray( board, word, start+1, x+dir[0], y+dir[1]);
            if(result)
                return true;
        }
        board[x][y]=word.charAt(start);
        return false;
    }
}
