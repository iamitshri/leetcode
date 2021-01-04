package com.practice;

import java.util.HashMap;

public class UniquePaths {
    int uniquePathsDynamicProgramming(int m , int n){

        int[][] dp =new int[m][n];

        for(int i=0; i < m ; i++){
            dp[i][0]=1;
        }
        for(int i=0; i < n ; i++){
            dp[0][i]=1;
        }

        for(int i=1; i < m ; i++){
            for(int j=1; j < n; j++){
                dp[i][j]= dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    HashMap<String, Integer> map = new HashMap<>();

    int uniquePathsHelper(int m , int n){

        if( m < 0 || n < 0 )
            return 0;

        if(m==0 || n==0)
            return 1;


        if(!map.containsKey(m+"-"+n)){
            int a = uniquePathsHelper(m-1,n) ;
            int b = uniquePathsHelper(m,n-1);
            map.put(m+"-"+n,a+b);
        }

        return map.get(m+"-"+n);
    }


}
