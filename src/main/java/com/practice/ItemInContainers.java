package com.practice;

import java.util.Arrays;

public class ItemInContainers {

    public static void main(String[] args) {
        String str = "|**|***";
        int start[] = {1};
        int end[] = {str.length()};
        int[] result = findItemsInContainers(str, start, end);
        Arrays.stream(result)
              .forEach(System.out::print);

        System.out.println();
        result = numberOfItems(str, start, end);
        Arrays.stream(result)
              .forEach(System.out::print);
    }

    /**
     * @param s
     * @param startIndices
     * @param endIndices
     * @return
     */
    public static int[] numberOfItems(String s, int[] startIndices, int[] endIndices) {
        int[] ans = new int[startIndices.length];
        for (int i = 0; i < startIndices.length; i++) {
            int start = startIndices[i] - 1;
            int end = endIndices[i] - 1;
            int sum = 0, tmp = 0;
            while (start <= end && s.charAt(start) == '*') {
                start++;
            }
            while (start <= end) {
                if (s.charAt(start) == '*') {
                    tmp++;
                } else if (s.charAt(start) == '|') {
                    sum += tmp;
                    tmp = 0;
                }
                start++;
            }
            ans[i] = sum;
        }
        return ans;
    }

    /**
     * @param items
     * @param start
     * @param end
     * @return
     */
    static int[] findItemsInContainers(String items, int[] start, int[] end) {
        int[] result = new int[start.length];
        int p = 0;
        for (int i = 0; i < start.length; i++) {
            int l = start[i] - 1;
            int r = end[i] - 1;

            boolean left = false;
            boolean right = false;
            int stars = 0;
            int total = 0;
            for (int k = l; k <= r; k++) {
                if (items.charAt(k) == '|') {
                    if (!left) {
                        left = true;
                    } else {
                        right = true;
                        total += stars;
                        stars = 0;
                    }
                } else if (left && items.charAt(k) == '*') {
                    stars++;
                }
            }
            result[p++] = total;
        }
        return result;
    }
}
