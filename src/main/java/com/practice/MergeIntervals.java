package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Definition for an interval.
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {

	Comparator<Interval> cmp = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			// if(o1==null && o2==null)
			// {
			// return -1;
			// }
			if (o1.start > o2.start)
				return 1;
			else if (o1.start < o2.start)
				return -1;
			else
				return 0;

		}

	};

	public Interval combineInteval(Interval i1, Interval i2) {

		if (i1 == null)
			return i2;
		else if (i2 == null)
			return i1;
		else {
			if (i2.start <= i1.end)
				return new Interval(i1.start, i2.end >= i1.end ? i2.end : i1.end);
			else
				return null;
		}

	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0) {
			return result;
		}

		if (intervals.size() == 1) {
			return intervals;
		}

		Collections.sort(intervals, cmp);
		Interval combined = null, newCombined = null;
		for (int i = 0; i < intervals.size() - 1; i++) {

			if (combined == null) {
				combined = combineInteval(intervals.get(i), intervals.get(i + 1));
				if (combined == null) {
					result.add(intervals.get(i));
				}

			} else {
				newCombined = combineInteval(combined, intervals.get(i + 1));
				if (newCombined == null) {
					result.add(combined);

				}
				combined = newCombined;
			}

			if (i + 1 == intervals.size() - 1) {
				if (combined != null)
					result.add(combined);
				else
					result.add(intervals.get(i + 1));
			}
		}

		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stu
	}

}
