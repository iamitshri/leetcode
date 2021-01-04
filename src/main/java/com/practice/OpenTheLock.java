package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {

        Set<String> visited = new HashSet<>();
        Set<String> deadset = new HashSet<>(Arrays.asList(deadends));
        LinkedList<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");

        if (deadset.contains("0000")) {
            return -1;
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();

                if (target.equals(s)) {
                    return level;
                }

                for (int j = 0; j < 4; j++) {

                    char c = s.charAt(j);
                    String s1 = "";
                    String s2 = "";
                    s1 = s.substring(0, j) + (c == '9' ? '0' : (char) (c + 1)) + s.substring(j + 1);
                    s2 = s.substring(0, j) + (c == '0' ? '9' : (char) (c - 1)) + s.substring(j + 1);
                    if (!visited.contains(s1) && !deadset.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !deadset.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            level++;
        }
        return -1;

    }
}
