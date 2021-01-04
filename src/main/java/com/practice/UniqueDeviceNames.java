package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueDeviceNames {

    public static void main(String[] args) {
        List<String> result = uniqueDevices(Arrays.asList("switch", "tv", "switch", "tv", "switch", "tv"));
        result.forEach(System.out::println);
    }
    /**
     * https://aonecode.com/amazon-online-assessment-unique-device-names
     * https://www.geeksforgeeks.org/expedia-online-test-for-sde-2/
     */
    public static List<String> uniqueDevices(List<String> list){
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String s : list){
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
                result.add(s+""+map.get(s));
            }else{
                map.put(s,0);
                result.add(s);
            }
        }
        return result;
    }
}
