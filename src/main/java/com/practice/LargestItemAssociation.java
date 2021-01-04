package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PairString {

    String first;
    String second;

    PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}

/**
 *https://leetcode.com/discuss/interview-question/844979/amazon-oa-2020-largest-item-association
 */
public class LargestItemAssociation {

    /**
     * itemAssociation: [ [Item1, Item2], [Item3, Item4], [Item4, Item5] ] Output: [Item3, Item4, Item5]
     *
     * @param args
     */
    public static void main(String[] args) {
        List<PairString> pairStrings = new ArrayList<>();
        PairString ps1 = new PairString("Item1", "Item2");
        PairString ps2 = new PairString("Item3", "Item4");
        PairString ps3 = new PairString("Item4", "Item5");
        pairStrings.add(ps1);
        pairStrings.add(ps2);
        pairStrings.add(ps3);
        List<String> result = largestItemAssociation(pairStrings);
        System.out.println(String.join(",",result));
    }

    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        UnionFindUsingMap uf = new UnionFindUsingMap(itemAssociation);
        for (PairString ps : itemAssociation) {
            uf.union(ps.first, ps.second);
        }
        Map<String, Set<String>> result = new HashMap<>();
        for (PairString ps : itemAssociation) {

            String parent = uf.find(ps.first);
            result.put(parent, result.getOrDefault(parent, new HashSet<>()));
            result.get(parent)
                  .add(ps.first);

            parent = uf.find(ps.second);
            result.put(parent, result.getOrDefault(parent, new HashSet<>()));
            result.get(parent)
                  .add(ps.second);
        }

        Set<String> maxSet=null;
        int max=0;
        for (Map.Entry<String, Set<String>> entry : result.entrySet()) {
            if(entry.getValue().size() > max){
                max = entry.getValue().size();
                maxSet = entry.getValue();
            }
            System.out.println("key:" + entry.getKey() + " :value: " + entry.getValue()
                                                                            .size());
        }
        return new ArrayList<>(maxSet);
    }

}

/**
 * https://github.com/cherryljr/LintCode/blob/master/Maximum%20Association%20Set.java
 *
 * https://codereview.stackexchange.com/questions/49186/generic-implementation-of-the-quick-union-algorithm-with-path-compression
 */
class UnionFindUsingMap {

    Map<String, String> map;
    Map<String, Integer> sizeMap;

    UnionFindUsingMap(List<PairString> pairs) {
        map = new HashMap<>();
        sizeMap = new HashMap<>();
        for (PairString p : pairs) {
            map.put(p.first, p.first);
            map.put(p.second, p.second);
            sizeMap.put(p.first, 1);
            sizeMap.put(p.second, 1);
        }
    }

    String find(String s) {
        while (!s.equals(map.get(s))) {
            s = map.get(s);
        }
        return s;
    }

    void union(String s1, String s2) {
        String parentS1 = find(s1);
        String parentS2 = find(s2);

        if (parentS2.equals(parentS1)) {
            return;
        }

        if (sizeMap.get(parentS1) > sizeMap.get(parentS2)) {
            sizeMap.put(parentS1, sizeMap.get(parentS1) + sizeMap.get(parentS2));
            map.put(parentS2, parentS1);
        } else {
            sizeMap.put(parentS2, sizeMap.get(parentS2) + sizeMap.get(parentS1));
            map.put(parentS1, parentS2);
        }

    }
}
