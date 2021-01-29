package com.practice.string;

public class Palindrome {

    public static boolean isPalindrome(String text) {
        if(text.length()==1)
            return true;
        if(text.length()==2){
            return text.charAt(0)==text.charAt(text.length()-1);
        }
        return text.charAt(0)==text.charAt(text.length()-1) && isPalindrome(text.substring(1,text.length()-1));
    }
}
