package com.practice.dp;

public class LongestPalindromicSubstring {

    public String longestPalindromeBottomUp(String s) {
        // Bottom up approach
        int len = s.length();

        int begin=0;
        int finish=0;

        boolean [][] dp = new boolean[len][len];
        int max=1;

        for(int i =0; i < len ; i++)
            dp[i][i]=true;

        for(int start=len-1; start >=0 ; start-- ){
            for(int end=start+1; end < len ; end++){

                if(s.charAt(start)==s.charAt(end)){
                    if(end-start==1 || dp[start+1][end-1]){
                        dp[start][end]=true;
                        int size = end - start +1 ;
                        if(size> max){
                            begin = start;
                            finish = end;
                            max = size;
                        }
                    }
                }

            }
        }

        return s.substring(begin,finish+1);
    }

    public String longestPalindrome(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        lp(s, dp, 0, s.length() - 1);
        return s.substring(start, end + 1);
    }

    int max = 0;
    int start = 0;
    int end = 0;

    int lp(String s, Integer[][] dp, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }

        if (dp[startIndex][endIndex] == null) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                int remainingLen = endIndex - startIndex - 1;
                if (remainingLen == lp(s, dp, startIndex + 1, endIndex - 1)) {
                    remainingLen += 2;
                    dp[startIndex][endIndex] = remainingLen;
                    if (remainingLen > max) {
                        max = remainingLen;
                        start = startIndex;
                        end = endIndex;
                    }
                    return dp[startIndex][endIndex];
                }
            }
            int c1 = lp(s, dp, startIndex + 1, endIndex);
            int c2 = lp(s, dp, startIndex, endIndex - 1);
            dp[startIndex][endIndex] = Math.max(c1, c2);
        }
        return dp[startIndex][endIndex];
    }
}
