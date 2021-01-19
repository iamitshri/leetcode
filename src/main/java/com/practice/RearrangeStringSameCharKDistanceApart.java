package com.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringSameCharKDistanceApart {

    public static void main(String[] args) {
        RearrangeStringSameCharKDistanceApart r = new RearrangeStringSameCharKDistanceApart();
        String reorganizeString = r.rearrangeString("aabbcc", 3);
        System.out.println("Answer:" + reorganizeString);

    }


    public String rearrangeString2(String str, int k) {

        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        Queue<Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (entry1, entry2) -> entry2.getValue() - entry1.getValue());

        Queue<Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()) {

            Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }

        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }

    class PairCompartor implements Comparator<Pair> {

        public int compare(Pair p1, Pair p2) {
            return -1 * Integer.compare(p1.cnt, p2.cnt);
        }
    }


    public class Pair {

        public char c;
        public int cnt;

        Pair(char _c, int _cnt) {
            c = _c;
            cnt = _cnt;
        }
    }


    public String rearrangeString(String s, int k) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairCompartor());
        for (Character k1 : map.keySet()) {
            pq.add(new Pair(k1, map.get(k1)));
        }

        LinkedList<Pair> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            Pair pair = pq.poll();
            sb.append(pair.c);
            pair.cnt = pair.cnt - 1;
            queue.add(pair);

            if (queue.size() < k) {
                continue;
            }
            Pair item = queue.poll();
            if (item.cnt > 0) {
                pq.offer(item);
            }

        }

        return sb.length() == s.length() ? sb.toString() : "";

    }
}
