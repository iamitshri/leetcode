package com.practice.bfs;

import java.util.LinkedList;

public class RottingOranges {

    public int orangesRottingBetter(int[][] grid) {
        // every minute means, process the current queue size
        // min number of minues for all the oranges to become rotten
        // count all fresh oranges, whenver a rotten orange rots fresh orange we will
        if(grid==null || grid.length==0)
            return 0;

        LinkedList<Integer> queue = new LinkedList<>();
        int freshOrange=0;
        int r = grid.length;
        int c = grid[0].length;
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length;j++){
                if(grid[i][j]==1){
                    freshOrange++;
                }else if(grid[i][j]==2){
                    queue.add( i * c + j);
                }
            }
        }
        if(freshOrange==0)
            return 0;
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i < size;i++){
                int n = queue.poll();
                int x = n/c;
                int y = n%c;
                for(int [] dir : dirs){
                    int x1 = x + dir[0];
                    int y1 = y + dir[1];

                    if(x1<0 || x1>=r || y1 <0|| y1>=c || grid[x1][y1]!=1) // if not fresh dont add to queue
                        continue;

                    grid[x1][y1]=2; // rotten the orange
                    freshOrange--; // reduce fresh orange count
                    if(freshOrange==0)
                        return minutes+1;

                    queue.add(x1*c+y1);
                }
            }

            minutes++;
        }

        return -1;

    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int freshOrangeCnt = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOrangeCnt++;
                }
            }
        }
        int clock = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] item = queue.remove();
                int row = item[0];
                int col = item[1];

                for (int[] d : dirs) {

                    int r = row + d[0];
                    int c = col + d[1];

                    if (r < 0 || r >= m || c < 0 || c >= n) {
                        continue;
                    }

                    if (grid[r][c] == 1) {  // fresh orange
                        grid[r][c] = 2;// rot the fresh orange and put it in the queue for next round
                        queue.offer(new int[]{r, c});
                        freshOrangeCnt--;
                    }
                }

            }
            if (!queue.isEmpty()) {
                clock++;
            }
        }

        return freshOrangeCnt == 0 ? clock : -1;
    }
}
