package com.practice;
import java.util.*;



class IntervalsIntersection {

    public static Interval[] mergeAuthor(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<Interval>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            // check if the interval arr[i] intersects with arr2[j]
            // check if one of the interval's start time lies within the other interval
                if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
                    || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
                // store the intersection part
                result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }

            // move next from the interval which is finishing first
            if (arr1[i].end < arr2[j].end)
                i++;
            else
                j++;
        }

        return result.toArray(new Interval[result.size()]);
    }

    public static Interval[] merge(Interval[] a1, Interval[] a2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        int i=0,j=0;
        while(i < a1.length && j < a2.length){

            if(a1[i].start >= a2[j].start && a1[i].start  <= a2[j].end ){
                Interval n = new Interval(a1[i].start, Math.min(a1[i].end, a2[j].end)) ;
                intervalsIntersection.add(n );
                i++;
            }else if(a2[j].start >= a1[i].start &&  a2[j].start <= a1[i].end  ){
                Interval n = new Interval(a2[j].start, Math.min(a1[i].end, a2[j].end));
                intervalsIntersection.add(n );
                j++;
            }else if(a2[j].start > a1[i].end){
                i++;
            }else{
                j++;
            }

        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
