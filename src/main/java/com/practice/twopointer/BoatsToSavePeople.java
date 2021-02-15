package com.practice.twopointer;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int num = 0;
        while (i <= j) {
            num++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return num;
    }
}
