package com.practice;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary a = new AlienDictionary();

        String[] words = new String[]{"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean answer = a.isAlienSorted(words, order);
        System.out.println(answer);
    }

    public boolean isAlienSorted(String[] words, String order) {

        int arr[] = new int[26];// dictionary

        int i = 1;
        for (char c : order.toCharArray()) {
            arr[c - 'a'] = i++;
        }

        int prev = -1;
        int pos = 0;
        for (String word : words) {
            prev = -1;
            for (char current : word.toCharArray()) {
                pos = arr[current - 'a'];
                if (prev != -1 && pos < prev) {
                    return false;
                }
                prev = pos;
            }
        }

        return true;
    }
}
