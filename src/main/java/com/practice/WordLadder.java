package com.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        LinkedList<String> queue = new LinkedList<>();
        // add beging word to queue
        // process the queue
        // for each item in the queue, find out new string differing by one char
        // also it is present in the wordlist,
        // add the item in the queue , keep the count of hopes
        queue.add(beginWord);
        int level = 1;
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                // for each lettter , find the next and prev letter and create string
                // N  * M * 26
                for (int j = 0; j < word.length(); j++) {
                    char cur = word.charAt(j);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == cur) {
                            continue;
                        }
                        String upstr = word.substring(0, j) + String.valueOf(c) + word.substring(j + 1, word.length());
                        if (set.contains(upstr)) {
                            queue.offer(upstr);
                            set.remove(upstr);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
