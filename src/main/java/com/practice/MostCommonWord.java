package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
        String answer = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"});
        System.out.println(answer);
    }

    /**
     * https://leetcode.com/problems/most-common-word/
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public static String mostCommonWord(String paragraph, String[] banned) {
        // answer is unique
        // "abc is Abc is not abC Not not"
        // banned words: not
        // word itself do not contain any nonword character like punctuational chars
        if(paragraph==null || paragraph.isEmpty()){
            return "";
        }

        String [] words = paragraph.split("\\W+");
        //paragraph.replaceAll("\\W+"," ");
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList((banned)));

        int max=0;
        String maxWord="";
        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            w = w.toLowerCase();
            if(!set.contains(w)){
                map.put(w,map.getOrDefault(w,0)+1);
                if(max <= map.get(w)){
                    max = map.get(w);
                    maxWord = w;
                }
            }
        }
        return maxWord;
    }
}
