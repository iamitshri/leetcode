package com.practice.array;

public class MoveZerosToEnd {


    public  void moveZerosInPlaceRelativeOrderMaintained(int[] nums) {
        int writePointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writePointer++] = nums[i];
            }
        }
        while (writePointer < nums.length) {
            nums[writePointer++] = 0;
        }

    }

    public static void moveZeros(int[] nums) {
        int l = nums.length - 1;
        int j = 0;
        for (int i = 0; i <= l; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j <= l) {
            nums[j] = 0;
            j++;
        }
    }


    public static void moveZeros2(int[] nums) {
        int l = nums.length - 1;
        int j = 0;
        for (int i = 0; i <= l; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

}
