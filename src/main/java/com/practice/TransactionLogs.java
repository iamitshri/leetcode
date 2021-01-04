package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionLogs {

    public static void main(String[] args) {
        String[] lst = processLogFile(new String[]{"88 99 200", "88 99 300", "99 32 100", "12 12 15"}, 2);
        for (String s : lst) {
            System.out.println(s);
        }
    }

    /**
     * logs = ["88 99 200", "88 99 300", "99 32 100", "12 12 15"]
     * <p>
     * threshold = 2
     *
     * @return
     */
    static String[] processLogFile(String[] logs, int threshold) {

        if (logs == null || logs.length == 0 || threshold < 0) {
            return new String[0];
        }
        String[] result = new String[0];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String log : logs) {
            String[] arr = log.split("\\s");
            int from = Integer.parseInt(arr[0].trim());
            int to = Integer.parseInt(arr[1].trim());
            map.put(from, map.getOrDefault(from, 0) + 1);
            if (map.get(from) >= threshold) {
                list.add(from);
            }
            if (from != to) {
                map.put(to, map.getOrDefault(to, 0) + 1);
                if (map.get(to) >= threshold) {
                    list.add(to);
                }
            }

        }
        Collections.sort(list);
        List<String> strList = list.stream()
                                   .map(n -> String.valueOf(n))
                                   .collect(Collectors.toList());

        return strList.toArray(new String[0]);
    }

}
