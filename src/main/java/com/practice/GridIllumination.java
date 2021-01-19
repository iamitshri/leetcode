package com.practice;

import java.util.HashMap;
import java.util.Map;

public class GridIllumination {

    // Now working
    public static void main(String[] args) {
        GridIllumination g = new GridIllumination();

        int n=5;
        int [][] lamps = {{0,0},{4,4}};
        int [][] queries = {{1,1},{1,0}};
        int[] answer = g.gridIllumination(n, lamps, queries);
        for (int a: answer){
            System.out.print(a+" ");
        }
    }
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

        //GRID size N
        int [][] grid = new int[N][N];

        // row lamps map
        // col lamps map
        // TL to BR diagonal map
        // TR to BL diagonal map
        // query xi yi =  x*N + Yi is it on or off?

        int [][] dirs = {{-1,-1},{1,-1}, {-1,1},{1,1},{0,1},{0,-1},{1,0},{-1,0}};
        int [] ans = new int[queries.length];
        int cnt=0;

        Map<Integer,Integer> rowmap = new HashMap<>();
        Map<Integer,Integer> colmap = new HashMap<>();
        Map<Integer,Integer> tlbrmap = new HashMap<>();
        Map<Integer,Integer> trblmap = new HashMap<>();

        for(int []lamp : lamps){
            // When a lamp is turned on, it illiminates its cell and any cell in the same row, column or diagonal with this this cell.
            int i = lamp[0];
            int j = lamp[1];
            grid[i][j] =1 ;
            rowmap.put(i,rowmap.getOrDefault(i,0)+1);
            colmap.put(j,colmap.getOrDefault(j,0)+1);
            trblmap.put(i+j,trblmap.getOrDefault(i+j,0)+1);
            tlbrmap.put(i-j,tlbrmap.getOrDefault(i-j,0)+1);
        }

        for(int [] q : queries){
            int x = q[0];
            int y = q[1];
            // For the ith query, you should answer whether grid[xi][yi] is illuminated or not
            if( rowmap.containsKey(x) && rowmap.get(x)!=-1 ||
                    colmap.containsKey(y) && colmap.get(y)!=-1||
                    trblmap.containsKey(x+y) && trblmap.get(x+y)!=-1||
                    tlbrmap.containsKey(x-y) && tlbrmap.get(x-y)!=-1){

                ans[cnt++] = 1;
                //After answering the ith query, you should turn off the lamp at grid[xi][yi]
                grid[x][y]=0;
                rowmap.put(x,rowmap.getOrDefault(x,0)-1);
                colmap.put(y,colmap.getOrDefault(y,0)-1);
                trblmap.put(x+y,trblmap.getOrDefault(x+y,0)-1);
                tlbrmap.put(x-y,tlbrmap.getOrDefault(x-y,0)-1);
            }



            //and all of its 8 adjacent lamps if they exist (i,e, lamps at adjacent cell which share side or diagonal).
            for( int [] dir: dirs){

                int i = x+dir[0];
                int j = y+dir[1];
                if(i< N && i >=0 && j < N && j>=0){
                    grid[i][j]=0;
                    rowmap.put(i,rowmap.getOrDefault(i,0)-1);
                    colmap.put(j,colmap.getOrDefault(j,0)-1);
                    trblmap.put(i+j,trblmap.getOrDefault(i+j,0)-1);
                    tlbrmap.put(i-j,tlbrmap.getOrDefault(i-j,0)-1);
                }
            }
        }


        return ans;

    }
}
