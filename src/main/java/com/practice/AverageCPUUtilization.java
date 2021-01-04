package com.practice;

public class AverageCPUUtilization {

    public static void main(String[] args) {
       int result= finalInstances(2,new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80});
        System.out.println(result);
    }

    public static int finalInstances(int instances, int[] averageUtil) {

        int total = instances;
        int i = 0;
        while (i < averageUtil.length) {

            if (averageUtil[i] < 25 && total > 1) {
                // if already 1 dont reduce
                // take ceiling
                total = (int) Math.ceil(total / 2.0);
                i += 10;
            } else if (averageUtil[i] > 60) {
                // check if doubling increases capacity beyond limit
                if (((total * 2) <= 200000000)) {
                    total = 2 * total;
                    i += 10;
                }
            }

            i++;
        }
        return total;
    }

}
