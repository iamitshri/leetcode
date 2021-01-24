package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        int cycle = 0;
        boolean hasCycle = false;
        Set<String> set = new HashSet<>();
        for (int j = 0; j < N; j++) {

            int[] tmp = nextDay(cells);
            String t = Arrays.toString(tmp);
            if (!set.contains(t)) {
                cycle++;
                set.add(t);
            } else {
                hasCycle = true;
                break;
            }
            cells = tmp;
        }

        if (hasCycle) {
            N = N % cycle;
            for (int i = 0; i < N; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }


    int[] nextDay(int[] cells) {
        int[] temp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                temp[i] = 1;
            } else {
                temp[i] = 0;
            }
        }
        return temp;
    }
}
