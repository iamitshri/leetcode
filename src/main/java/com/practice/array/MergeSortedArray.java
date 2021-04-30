package com.practice.array;

public class MergeSortedArray {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a
     * size equal to m + n such that it has enough space to hold additional elements from nums2.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output: [1,2,2,3,5,6] Example 2:
     * <p>
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0 Output: [1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * nums1.length == m + n nums2.length == n 0 <= m, n <= 200 1 <= m + n <= 200 -109 <= nums1[i], nums2[i] <= 109
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
