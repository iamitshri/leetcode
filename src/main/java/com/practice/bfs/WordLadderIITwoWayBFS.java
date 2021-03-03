package com.practice.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderIITwoWayBFS {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }

        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Map<String, List<String>> map = new HashMap<>();
        boolean reverse = false;

        bfs(startSet, endSet, map, endWord, dict, reverse);

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

    void bfs(Set<String> startSet, Set<String> endSet, Map<String, List<String>> map, String endWord, Set<String> dict,
        boolean reverse) {

        if (startSet.size() == 0) {
            return;
        }

        // if startSet is bigger than the endSet we reverse
        if (startSet.size() > endSet.size()) {
            bfs(endSet, startSet, map, endWord, dict, !reverse);
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
                        if (endSet.contains(newWord)) {
                            finish = true;
                        } else {
                            tmp.add(newWord);
                        }
                        String key = reverse ? newWord : word;
                        String val = reverse ? word : newWord;
                        map.putIfAbsent(key, new ArrayList<>());
                        map.get(key)
                           .add(val);
                    }
                }
                arr[i] = old;
            }
        }

        if (!finish) {
            bfs(tmp, endSet, map, endWord, dict, reverse);
        }
    }
}
