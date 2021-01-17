package com.practice.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }

        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);

        Map<String, List<String>> map = new HashMap<>();
        bfs(startSet, map, endWord, dict);
        List<String> lst = new ArrayList<>();
        lst.add(beginWord);
        dfs(map, res, lst, beginWord, endWord);
        return res;
    }

    void dfs(Map<String, List<String>> map, List<List<String>> res, List<String> lst, String beginWord,
        String endWord) {

        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(lst));
            return;
        }

        if (map.get(beginWord) == null) {
            return;
        }

        for (String w : map.get(beginWord)) {
            lst.add(w);
            dfs(map, res, lst, w, endWord);
            lst.remove(lst.size() - 1);
        }

    }

    void bfs(Set<String> startSet, Map<String, List<String>> map, String endWord, Set<String> dict) {

        if (startSet.isEmpty()) {
            return;
        }

        // remove all startSet
        dict.removeAll(startSet);
        boolean finish = false;
        Set<String> tmp = new HashSet<>();
        for (String word : startSet) {
            char[] arr = word.toCharArray(); // char array
            for (int i = 0; i < word.length(); i++) {
                char old = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if (dict.contains(newWord)) {
                        if (endWord.equals(newWord)) {
                            finish = true;
                        } else {
                            tmp.add(newWord);
                        }
                        map.putIfAbsent(word, new ArrayList<>());
                        map.get(word)
                           .add(newWord);
                    }
                }
                arr[i] = old;
            }
        }

        // process next set of words in the next level if not finished
        if (!finish) {
            bfs(tmp, map, endWord, dict);
        }
    }


}


