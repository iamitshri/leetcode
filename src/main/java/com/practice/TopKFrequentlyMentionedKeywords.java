package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentlyMentionedKeywords {

    public static void main(String[] args) {
        String[] kws = {"newshop", "shopnow", "afashion", "fashionbeats", "mymarket", "tcellular"};
        String[] reviews = {"newshop is providing good services in the city; everyone should use newshop",
            "best services by newshop", "fashionbeats has great services in the city",
            "I am proud to have fashionbeats", "mymarket has awesome services",
            "Thanks Newshop for the quick delivery"};
        List<String> result = topNumCompetitors(2, Arrays.asList(kws), Arrays.asList(reviews));
        System.out.println(String.join(",",result));
    }

    /**
     * Example Input: numCompetitors=6 topNCompetitors = 2 competitors = [newshop, shopnow, afashion, fashionbeats,
     * mymarket, tcellular] numReviews = 6 reviews = [ "newshop is providing good services in the city; everyone should
     * use newshop", "best services by newshop", "fashionbeats has great services in the city", "I am proud to have
     * fashionbeats", "mymarket has awesome services", "Thanks Newshop for the quick delivery" ]
     * <p>
     * Output ["newshop", "fashionbeats"]
     *
     * @param topNCompetitors
     * @param competitors
     * @param reviews
     * @return
     */
    public static List<String> topNumCompetitors(int topNCompetitors, List<String> competitors,
        List<String> reviews) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.n - a.n);
        for (String kw : competitors) {
            int cnt = 0;
            kw = kw.toLowerCase();
            for (String review : reviews) {
                review = review.toLowerCase();
                if (review.contains(kw)) {
                    cnt++;
                }
            }
            pq.add(new Pair(kw, cnt));
        }
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty() && topNCompetitors > 0) {
            list.add(pq.poll().s);
            topNCompetitors--;
        }
        return list;
    }

}

class Pair {

    String s;
    int n;

    Pair(String s, int n) {
        this.s = s;
        this.n = n;
    }
}