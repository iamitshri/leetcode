package com.practice;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

	public class IntervalComparator implements Comparator<Interval> {

		public int compare(Interval i1, Interval i2) {

			return i1.end - i2.end;
		}

	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
 		// sort by finishing time.
		Arrays.sort(intervals, new IntervalComparator());

		int end = intervals[0].end;
		int count = 1;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start >= end) {
				end = intervals[i].end;
				count++;
			}
		}

		return intervals.length - count;
	}

	public static void main(String[] args) {
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(2, 3);
		Interval i3 = new Interval(3, 4);
		Interval i4 = new Interval(1, 3);
		Interval i5 = new Interval(1, 2);

		EraseOverlapIntervals e = new EraseOverlapIntervals();
		Interval i[] = new Interval[] { i1, i2, i3, i4 };
		System.out.println(e.eraseOverlapIntervals(i));

	}
}
