package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {

        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }

        // a1b2
        // a1b2 A1b2
        // a1b2 A1b2 a1B2 A1B2
        result.add(s);
        for (int i = 0; i < s.length(); i++) {

            if (Character.isLetter(s.charAt(i))) {

                int size = result.size();
                for (int j = 0; j < size; j++) {

                    char[] ch = result.get(j)
                                      .toCharArray();

                    if (Character.isLowerCase(ch[i])) {
                        ch[i] = Character.toUpperCase(ch[i]);
                    } else {
                        ch[i] = Character.toLowerCase(ch[i]);
                    }

                    result.add(String.valueOf(ch));
                }
            }
        }
        return result;
    }

    public List<String> letterCasePermutation2(String s) {

        List<String> permutations = new ArrayList<>();
        permutations.add(s);
        for(int i=0; i < s.length();i++){
            if(!Character.isLetter(s.charAt(i))){
                continue;
            }
            int size = permutations.size();
            for(int j=0; j < size ;j++){
                char [] arr = permutations.get(j).toCharArray();
                if(Character.isUpperCase(arr[i])){
                    arr[i] = Character.toLowerCase(arr[i]);
                }else{
                    arr[i] = Character.toUpperCase(arr[i]);
                }
                permutations.add(new String(arr));
            }
        }

        return permutations;
    }
}
