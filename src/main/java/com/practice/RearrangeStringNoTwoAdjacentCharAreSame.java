package com.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringNoTwoAdjacentCharAreSame {

    public static void main(String[] args) {
            RearrangeStringNoTwoAdjacentCharAreSame r = new RearrangeStringNoTwoAdjacentCharAreSame();
        String reorganizeString = r.reorganizeString("aabbcc");
        System.out.println("Answer:"+reorganizeString);

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


    public String reorganizeString(String s) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairCompartor());
        for( Character k : map.keySet()){
            pq.add(new Pair(k,map.get(k)));
        }

        StringBuilder sb = new StringBuilder();
        Pair ignore=null;
        // aabc
        //abac
        while(!pq.isEmpty()){

            Pair pair = pq.poll();
            sb.append(pair.c);

            // add the previously ignored pair
            if(ignore!=null && ignore.cnt>0){
                pq.add(ignore);
            }

            // decrement the frequency
            pair.cnt = pair.cnt -1 ;
            ignore=pair;
        }

        if(ignore.cnt>0){
            return "";
        }

        return sb.toString();
    }

}
