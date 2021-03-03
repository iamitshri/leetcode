package com.practice.string;

import java.util.List;
import java.util.stream.Collectors;

public class ValidPalinDrome {

    public static boolean validPalinDrome(String s) {

        // optional
        //s.replaceAll("\\W","").toLowerCase();

        int l = 0;
        int h = s.length() - 1;
        while (l < h) {
            while (l < h && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < h && !Character.isLetterOrDigit(s.charAt(h))) {
                h--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(h))) {
                return false;
            }
            l++;
            h--;
        }

        return true;

    }

    List<Character> filterNonAlphanumericCharacters(String s){
        return s.codePoints()
                                .mapToObj(c -> (char) c)
                                .filter(Character::isLetterOrDigit)
                                .collect(Collectors.toList());
    }
}
