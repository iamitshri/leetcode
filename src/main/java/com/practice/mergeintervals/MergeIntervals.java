package com.practice.mergeintervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> ll = new LinkedList<>();
        for (int[] interval : intervals) {
            if (ll.isEmpty() || interval[0] > ll.getLast()[1]) {
                ll.add(interval);
            } else {
                ll.getLast()[1] = Math.max(interval[1], ll.getLast()[1]);
            }
        }
        return ll.toArray(new int[ll.size()][2]);
    }
}
