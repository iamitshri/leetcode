package com.practice;

public class TwoDimensionalArrayUtil {

    public static void main(String[] args) {
        TwoDimensionalArrayUtil t = new TwoDimensionalArrayUtil();
        t.eightDirections();
    }

    void  eightDirections(){
        int [][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        int [][] dirs = {{-1,-1},{1,-1}, {-1,1},{1,1},{0,1},{0,-1},{1,0},{-1,0}};

        for( int i =0; i < arr.length;i++){
            for( int j =0; j < arr[0].length;j++){
                System.out.println("changing neighbours of "+arr[i][j]);
                for( int [] dir: dirs){

                    int p = i+dir[0];
                    int q = j+dir[1];
                    if(p < arr.length && p >=0 && q < arr[0].length && q>=0){
                        arr[p][p]=999;
                    }
                }
            }
        }
        System.out.println("test");

    }
}
