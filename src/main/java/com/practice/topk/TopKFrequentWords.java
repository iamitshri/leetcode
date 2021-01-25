package com.practice.topk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        // add items to map
        // sort by values and keys
        // n log k

        PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue()
                       .equals(a.getValue()) ? b.getKey()
                                                      .compareTo(a.getKey()) : a.getValue() - b.getValue());

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entr : map.entrySet()) {
            pq.add(entr);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> lst = new LinkedList<>();
        while (!pq.isEmpty()) {
            lst.add(0, pq.poll()
                         .getKey());
        }
        return lst;
    }
}
