package com.practice.slidingwindow;

import java.util.HashMap;

public class MaximumPointsYouCanObtainFromCards {

    /**
     * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {

        int lSum = 0;
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }
        int rSum = 0;
        int max = lSum;
        for (int i = 0; i < k; i++) {
            lSum -= cardPoints[k - 1 - i];
            rSum += cardPoints[cardPoints.length - 1 - i];
            max = Math.max(max, lSum + rSum);
        }
        return max;
    }

    /**
     * This solution times out
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScoreRecursive(int[] cardPoints, int k) {
        //choose a card from the front or back
        //1 11 2 3 0 5

        maxSum = choose(cardPoints, 0, cardPoints.length - 1, k, 0);
        return maxSum;

    }

    int maxSum = 0;
    HashMap<String, Integer> map = new HashMap<>();

    int choose(int[] cardPoints, int start, int end, int k, int sum) {

        // if(k<=0){
        //   if(sum > maxSum){
        //     maxSum=sum;
        //   }
        //   return;
        // }

        if (k <= 0 || start > end) {
            return sum;
        }
        String key = start + ", " + end + ", " + k;
        if (map.get(key) == null) {
            int sum1 = choose(cardPoints, start + 1, end, k - 1, sum + cardPoints[start]);
            int sum2 = choose(cardPoints, start, end - 1, k - 1, sum + cardPoints[end]);
            map.put(key, Math.max(sum1, sum2));
        }
        return map.get(key);
    }

}
