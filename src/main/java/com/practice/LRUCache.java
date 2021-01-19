package com.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        /**
         * ["LRUCache","put","put","get","get","put","get","get","get"]
         * [[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
         */
        LRUCache lc = new LRUCache(2);
        lc.put(2,1);
        lc.put(3,2);
        lc.get(3);
        lc.get(2);
        lc.put(4,3);
        lc.get(2);
        lc.get(3);
        lc.get(4);
    }

    int capacity;
    LinkedList<Integer> ll = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ll.remove(Integer.valueOf(key));
            ll.addFirst(Integer.valueOf(key));
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            map.put(key,value);
            ll.remove(new Integer(key));
            ll.addFirst(key);

        }else if(map.size()>=capacity){

            if(!ll.isEmpty())
                map.remove( ll.removeLast());
            ll.addFirst(key);
            map.put(key,value);
        }else{

            ll.addFirst(key);
            map.put(key,value);
        }
    }
}
