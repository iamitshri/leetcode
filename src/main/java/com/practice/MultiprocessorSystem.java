package com.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MultiprocessorSystem {

    public static void main(String[] args) {
        int time = multiprocessorSystem(new int[]{3,1,7,2,4},5,15);
        System.out.println(time);
    }
    private static int multiprocessorSystem(int[] ability, int num, int processes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int a : ability) {
            pq.offer(a);
        }
        int cnt = 0;
        int totalTime = 0;
        while ( !pq.isEmpty()) {
            int a = pq.poll();
            pq.offer(a / 2);
            cnt += a;
            ++totalTime;
            if(cnt>=processes)
                break;
        }
        return totalTime;
    }
}
