package com.practice;

public class JumpGame {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int j = nums.length - 1;
        int i = j - 1;

        while (j > 0) {

            i = j - 1;
            while (i >= 0 && nums[i] < (j - i)) {
                i--;
            }
            if (i < 0) {
                return false;
            }
            j--;
        }

        if (j == 0) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        boolean canJump = j.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(canJump);
    }

}
