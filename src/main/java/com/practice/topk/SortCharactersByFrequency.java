package com.practice.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Entry<Character, Integer>> pq =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // o(# unique)
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var c = pq.poll();
            var cnt = c.getValue();
            while (cnt > 0) {
                sb.append(c.getKey());
                cnt--;
            }
        }
        return sb.toString();
    }
}
