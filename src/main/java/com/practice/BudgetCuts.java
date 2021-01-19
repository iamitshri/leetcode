package com.practice;

import java.util.Arrays;

public class BudgetCuts {

    static double findGrantsCap(double[] grantsArray, double newBudget) {

        if (grantsArray == null || grantsArray.length == 0 || newBudget < 0) {
            return 0;
        }

        Arrays.sort(grantsArray);
        int n = grantsArray.length;
        double remainingBudget = newBudget;
        double dividedRemBudget = (remainingBudget / n);
        for (int i = 0; i < grantsArray.length; i++) {
            if (grantsArray[i] < dividedRemBudget) {
                // current grant less than per member min budget
                n--; // decrement # of affected grants
                remainingBudget -= grantsArray[i];
                dividedRemBudget = remainingBudget / n;
            } else {
                break;
            }
        }
        return dividedRemBudget;
    }

    public static void main(String[] args) {
        BudgetCuts bc = new BudgetCuts();
        double[] arr = new double[]{2, 100, 50, 120, 167};
        System.out.println(findGrantsCap(arr, 400));
    }

}

