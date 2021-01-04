package com.practice;

public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        //
        boolean changed=false;

        char[] pal = palindrome.toCharArray();
        for(int i=0;i<pal.length/2;i++){
            if(pal[i]!='a'){
                pal[i]='a';
                return new String(pal);
            }
        }
        pal[pal.length-1]='b';
        return pal.length<2?"": new String(pal);
    }
}
