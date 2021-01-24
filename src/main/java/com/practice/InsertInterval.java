package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                   "start=" + start +
                   ", end=" + end +
                   '}';
    }
};

class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> mergedIntervals = new LinkedList<>();
        boolean processed=false;
        for(Interval i : intervals){

            // start
            if(!processed && newInterval.start < i.start ) {
                mergedIntervals.add(new Interval(newInterval.start, newInterval.end));
                processed=true;
            }
            else if( !processed && newInterval.start < i.end   ){
                i.end = Math.max(newInterval.end,i.end);
                processed=true;
            }

            if(mergedIntervals.size()==0 || i.start > mergedIntervals.getLast().end){
                mergedIntervals.add(i);
            }else{
                mergedIntervals.getLast().end=Math.max(i.end,mergedIntervals.getLast().end);
            }
        }

        if(newInterval.start >  mergedIntervals.getLast().end){
            mergedIntervals.add(newInterval);
        }else{
            mergedIntervals.getLast().end=Math.max(newInterval.end,mergedIntervals.getLast().end);
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
/**
 Intervals after inserting the new interval: [1,3] [4,7] [8,12]
 Intervals after inserting the new interval: [1,3] [4,12]
 Intervals after inserting the new interval: [1,4] [5,7]


 **/