package com.practice;

import java.util.PriorityQueue;

public class FulfillmentBuilder {

    public static void main(String[] args) {
        int time = minTimeAssembleParts(new int[]{1});
        System.out.println(time);
    }
    // time complexity= O(nlogn)
    // space complexity= O(n)
    static int minTimeAssembleParts(int[] parts) {

        if (parts == null || parts.length <= 1) {
            return 0;
        }

        // Collect: cost of combining parts
        // we will add elements to min Heap, so we can extract parts of lowest part size
        // we will combine the two lowest parts from the heap and put their sum back in

        // default min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int part : parts) {
            pq.offer(part);
        }
        int total = 0;
        // 1 2
        while (pq.size() > 1) {
            int t = 0;
            t += pq.poll();
            t += pq.poll();
            pq.add(t);
            total += t;
        }
        return total;
    }

}
