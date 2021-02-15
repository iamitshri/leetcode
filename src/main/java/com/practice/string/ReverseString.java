package com.practice.string;

import java.util.HashSet;

public class ReverseString {

    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
        int l=0; int r=s.length() -1;
        char [] arr = s.toCharArray();
        while(l < r){

            while(l < r && !set.contains(arr[l])){
                l++;
            }
            while(l < r && !set.contains(arr[r])){
                r--;
            }
            if(l< r){
                char c = arr[l];
                arr[l] = arr[r];
                arr[r] = c;
                l++;r--;
            }
        }
        return new String(arr);
    }

    public void reverseString(char[] s) {
        int l=0; int r=s.length -1;

        while(l < r){
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;r--;
        }

    }
}
