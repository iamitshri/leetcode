package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Turnstile {

    /**
     * https://leetcode.com/discuss/interview-question/699973/goldman-sachs-oa-turnstile
     *
     * @param n
     * @param arrTime
     * @param direction
     * @return
     */
    public static int[] turnstile(int n,  int[] arrTime, int[] direction) {

        int[] times = new int[n];

        // build the 2 queues
        List<Queue<List<Integer>>> queues = new ArrayList<>();
        queues.add(new LinkedList<>());
        queues.add(new LinkedList<>());
        for (int i = 0; i < n; i++) {
            queues.get(direction[i])
                  .add(Arrays.asList(arrTime[i], i));
        }

        // compare elements at the top to decide which queue is to process
        int currentTime = 0,
            priority = 1;
        while (!queues.get(0)
                      .isEmpty() || !queues.get(1)
                                           .isEmpty()) {
            Integer time0 = queues.get(0)
                              .isEmpty() ? Integer.MAX_VALUE : queues.get(0)
                                                                         .peek()
                                                                         .get(0),
                time1 = queues.get(1)
                              .isEmpty() ? Integer.MAX_VALUE : queues.get(1)
                                                                     .peek()
                                                                     .get(0);
            int faster = Math.min(time0, time1);

            // reset the priority
            if (faster - currentTime > 1) {
                priority = 1;
            }

            currentTime = Math.max(currentTime, faster);

            int comp = time0.compareTo(time1);
            int queueNumber = (comp == -1 || comp == 0 && priority == 0) ? 0 : 1;

            do {
                List<Integer> current = queues.get(queueNumber)
                                              .poll();
                times[current.get(1)] = currentTime;
                currentTime++;
            } while (!queues.get(queueNumber)
                            .isEmpty() && queues.get(queueNumber)
                                                .peek()
                                                .get(0) <= currentTime);

            priority = queueNumber;
        }
        return times;
    }

    public static void main(String args[]) {
        int n = 4;
        int[] arrTime = {0, 0, 1, 5};
        int[] direction = {0, 1, 1, 0};

        int[] times = turnstile(n, arrTime, direction);

        for (int i = 0; i < times.length; i++) {
            System.out.print(times[i]);
        }
        System.out.println();
    }


    static class Visitor {

        int id;
        int dir;
        int time;

        Visitor(int id, int dir, int time) {
            this.id = id;
            this.dir = dir;
            this.time = time;
        }
    }

    public int[] getTimes(int[] times, int[] directions) {
        int[] res = new int[times.length];
        int lastDir = 1;
        int timeStamp = 0;
        PriorityQueue<Visitor> enterQueue = new PriorityQueue<>(
            (o1, o2) -> o1.time == o2.time ? o1.id - o2.id : o1.time - o2.time);
        PriorityQueue<Visitor> exitQueue = new PriorityQueue<>(
            (o1, o2) -> o1.time == o2.time ? o1.id - o2.id : o1.time - o2.time);
        for (int i = 0; i < times.length; i++) {
            if (directions[i] == 1) {
                exitQueue.offer(new Visitor(i, 1, times[i]));
            } else {
                enterQueue.offer(new Visitor(i, 0, times[i]));
            }
        }
        while (!(enterQueue.isEmpty() && exitQueue.isEmpty())) {
            int nextEnterTime = enterQueue.isEmpty() ? Integer.MAX_VALUE : enterQueue.peek().time;
            int nextExitTime = exitQueue.isEmpty() ? Integer.MAX_VALUE : exitQueue.peek().time;
            if (nextEnterTime > timeStamp && nextExitTime > timeStamp) {
                lastDir = 1;
            } else if (nextEnterTime <= timeStamp && nextExitTime <= timeStamp) {
                Visitor v = lastDir == 1 ? exitQueue.poll() : enterQueue.poll();
                res[v.id] = timeStamp;
            } else {
                Visitor v = nextEnterTime <= timeStamp ? enterQueue.poll() : exitQueue.poll();
                res[v.id] = timeStamp;
                lastDir = v.dir;
            }
            timeStamp++;
        }
        return res;
    }

}
