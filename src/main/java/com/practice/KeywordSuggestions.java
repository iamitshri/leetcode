package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KeywordSuggestions {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        // linear search, sort the output list  searchwordLength * (O(n)+nlogn)

        // sort products binary search the chars in the search word: wordlength * logn

        // string find the prefix match
        // Trie
        // node has 26 chars
        // walking down
        // trie.

        // insert
        // search

        // for each substring of searchword we are going to find out how many products are starting with it
        // and we will add them to the queue
        List<List<String>> list = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= searchWord.length(); i++) {
            String searchTerm = searchWord.substring(0, i);
            for (String product : products) {
                if (product.startsWith(searchTerm)) {
                    pq.offer(product);
                    if (pq.size() > 3) {
                        pq.poll();
                    }
                }
            }
            List<String> l = new LinkedList<>();
            while (!pq.isEmpty()) {
                l.add(0, pq.poll());
            }
            list.add(l);
        }
        return list;
    }

    public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i);
            for (String product : products) {
                if (product.startsWith(t)) {
                    heap.offer(product);
                }
                if (heap.size() > 3) {
                    heap.poll();
                }
            }

            LinkedList<String> temp = new LinkedList<>();
            while (!heap.isEmpty()) {
                temp.addFirst(heap.poll());
            }
            result.add(temp);
        }
        return result;
    }

    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        PriorityQueue<String> pq = new PriorityQueue<>(3, (s1, s2) -> s1.compareTo(s2));
        List<List<String>> list = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String temp = searchWord.substring(0, i);
            for (String s : products) {
                if (s.startsWith(temp)) {
                    pq.offer(s);
                }
            }
            List<String> temp_list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (pq.peek() != null) {
                    temp_list.add(pq.poll());
                }
            }
            pq.clear();
            list.add(temp_list);
        }
        return list;
    }
}
