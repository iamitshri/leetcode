package com.practice.array;

import java.util.Arrays;

public class HeightChecker {

    /**
     * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file
     * line in non-decreasing order by height. Let this ordering be represented by the integer array expected where
     * expected[i] is the expected height of the ith student in line.
     * <p>
     * You are given an integer array heights representing the current order that the students are standing in. Each
     * heights[i] is the height of the ith student in line (0-indexed).
     * <p>
     * Return the number of indices where heights[i] != expected[i].
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: heights = [1,1,4,2,1,3] Output: 3 Explanation: heights:  [1,1,4,2,1,3] expected: [1,1,1,2,3,4] Indices 2,
     * 4, and 5 do not match. Example 2:
     * <p>
     * Input: heights = [5,1,2,3,4] Output: 5 Explanation: heights:  [5,1,2,3,4] expected: [1,2,3,4,5] All indices do
     * not match. Example 3:
     * <p>
     * Input: heights = [1,2,3,4,5] Output: 0 Explanation: heights:  [1,2,3,4,5] expected: [1,2,3,4,5] All indices
     * match.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= heights.length <= 100 1 <= heights[i] <= 100
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        // sort in the heights and then compare
        // sort and compare
        // each elem
        int[] temp = new int[heights.length];
        System.arraycopy(heights, 0, temp, 0, heights.length);
        Arrays.sort(temp);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public int heightCheckerWithLinearComplexity(int[] heights) {

        //counted sort
        int[] temp = new int[101];
        for (int h : heights) {
            temp[h]++;
        }
        int cnt = 0;
        int ptr = 0;
        for (int i = 0; i < heights.length; i++) {

            while (temp[ptr] == 0) {
                ptr++;
            }
            if (heights[i] != ptr) {
                cnt++;
            }
            temp[ptr]--;
        }
        return cnt;
    }
}
