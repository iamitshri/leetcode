package com.practice.topk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        Map<Integer, Integer> result = map.entrySet()
                                          .stream()
                                          .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                                          .limit(k)
                                          .collect(Collectors.toMap(
                                              Map.Entry::getKey,
                                              Map.Entry::getValue,
                                              (oldValue, newValue) -> oldValue, LinkedHashMap::new));

//        int[] res = new int[k];
//        int cnt = 0;
//        for (Integer entry : result.keySet()) {
//            if (cnt < k) {
//                res[cnt++] = entry;
//            }
//        }
//        return res;

        List<Integer> l = new ArrayList<>(result.keySet());
        return  l.stream().mapToInt(Integer::intValue).toArray();

    }

    public int[] topKFrequentUsingBucket(int[] nums, int o) {

        // solution using buckets

        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) map.put(n,map.getOrDefault(n,0)+1);

        List<Integer> [] bucket = new List[nums.length+1];

        for(int k : map.keySet()){
            int freq = map.get(k);
            if(bucket[freq]==null){
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(k);
        }

        List<Integer> result =new ArrayList<>();
        for(int k = bucket.length-1; o>0 && k>=0;k--){
            if(bucket[k]!=null){
                result.addAll( bucket[k]);
                o-=bucket[k].size();
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
