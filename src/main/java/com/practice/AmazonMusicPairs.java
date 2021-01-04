package com.practice;

import java.util.HashMap;
import java.util.Map;

public class AmazonMusicPairs {

    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) {
            return 0;
        }

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

      /*
      (a+b)%60=60
      a%60 = (60-b%60)%60;
      */
        for (int i = 0; i < time.length; i++) {
            int t = time[i] % 60;
            cnt += map.getOrDefault((60 - t) % 60, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return cnt;
    }
}
