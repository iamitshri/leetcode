package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OptimalUtilization {

    /**
     * https://leetcode.com/discuss/interview-question/373202
     * <p>
     * Input: a = [[1, 3], [2, 5], [3, 7], [4, 10]] b = [[1, 2], [2, 3], [3, 4], [4, 5]] target = 10
     * <p>
     * Output: [[2, 4], [3, 2]]
     * <p>
     * Input: a = [[1, 8], [2, 15], [3, 9]] b = [[1, 8], [2, 11], [3, 12]] target = 20
     * <p>
     * Output: [[1, 3], [3, 2]]
     *
     * @param a
     * @param b
     * @param target
     * @return
     */
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {

        // validation
        Collections.sort(a, Comparator.comparingInt(i -> i[1]));
        Collections.sort(b, Comparator.comparingInt(i -> i[1]));
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = b.size() - 1;
        List<int[]> result = new ArrayList<>();
        while (i < a.size() && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum > target) {
                j--;
            } else {
                // sum less than target
                if (sum >= max) {
                    if (sum > max) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j - 1;
                    while (index > 0 && b.get(index)[1] == b.get(index + 1)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index)[0]});
                        index--;
                    }
                }
                i++;
            }
        }
        return result;
    }
}
