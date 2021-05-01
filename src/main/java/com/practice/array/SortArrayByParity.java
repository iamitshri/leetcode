package com.practice.array;

public class SortArrayByParity {

    /**
     * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by
     * all the odd elements of A.
     * <p>
     * You may return any answer array that satisfies this condition.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= A.length <= 5000 0 <= A[i] <= 5000
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {

        int last = A.length;
        for (int i = 0; i < last; i++) {
            while (i < last && A[i] % 2 != 0) {
                swap(A, i, last - 1);
                last--;
            }
        }
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {

        int last = A.length;
        int i = 0;
        while (i < last) {
            if (A[i] % 2 != 0) {
                swap(A, i, last - 1);
                last--;
            } else {
                i++;
            }
        }

        return A;
    }

    void swap(int[] A, int i, int j) {

        int t = A[i];
        A[i] = A[j];
        A[j] = t;

    }
}
