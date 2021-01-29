package com.practice.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeneralizedAbbreviation {

    /**
     * The idea is: for every character, we can keep it or abbreviate it. To keep it, we add it to the current solution
     * and carry on backtracking. To abbreviate it, we omit it in the current solution, but increment the count, which
     * indicates how many characters have we abbreviated. When we reach the end or need to put a character in the
     * current solution, and count is bigger than zero, we add the number into the solution.
     *https://leetcode.com/problems/generalized-abbreviation/discuss/77190/Java-backtracking-solution
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> lst = new ArrayList<>();
        dfs(word, 0, "", lst, 0);
        return lst;
    }

    void dfs(String word, int pos, String current, List<String> result, int count) {

        if (pos == word.length()) {
            current += count > 0 ? count : "";
            result.add(current);
            return;
        }

        dfs(word, pos + 1, current + (count > 0 ? count : "") + word.charAt(pos), result, 0); // Keep the letter
        dfs(word, pos + 1, current, result, count + 1); // abbreviate it
    }

    static class AbbreviatedWord {

        StringBuilder str;
        int start;
        int count;

        public AbbreviatedWord(StringBuilder str, int start, int count) {
            this.str = str;
            this.start = start;
            this.count = count;
        }
    }

    public static List<String> generateGeneralizedAbbreviation(String word) {
        int wordLen = word.length();
        List<String> result = new ArrayList<>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.add(new AbbreviatedWord(new StringBuilder(), 0, 0));
        while (!queue.isEmpty()) {
            AbbreviatedWord abWord = queue.poll();
            if (abWord.start == wordLen) {
                if (abWord.count != 0) {
                    abWord.str.append(abWord.count);
                }
                result.add(abWord.str.toString());
            } else {
                // continue abbreviating by incrementing the current abbreviation count
                queue.add(new AbbreviatedWord(new StringBuilder(abWord.str), abWord.start + 1, abWord.count + 1));

                // restart abbreviating, append the count and the current character to the string
                if (abWord.count != 0) {
                    abWord.str.append(abWord.count);
                }
                queue.add(
                    new AbbreviatedWord(new StringBuilder(abWord.str).append(word.charAt(abWord.start)),
                                        abWord.start + 1, 0));
            }
        }

        return result;
    }


    public static List<String> generateGeneralizedAbbreviationRecur(String word) {
        List<String> result = new ArrayList<String>();
        generateAbbreviationRecursive(word, new StringBuilder(), 0, 0, result);
        return result;
    }

    private static void generateAbbreviationRecursive(String word, StringBuilder abWord, int start, int count,
        List<String> result) {

        if (start == word.length()) {
            if (count != 0)
                abWord.append(count);
            result.add(abWord.toString());
        } else {
            // continue abbreviating by incrementing the current abbreviation count
            generateAbbreviationRecursive(word, new StringBuilder(abWord), start + 1, count + 1, result);

            // restart abbreviating, append the count and the current character to the string
            if (count != 0)
                abWord.append(count);
            generateAbbreviationRecursive(word, new StringBuilder(abWord).append(word.charAt(start)), start + 1, 0, result);
        }
    }

}
