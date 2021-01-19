package com.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberRefuelingStops {

    public static void main(String[] args) {
        MinimumNumberRefuelingStops m = new MinimumNumberRefuelingStops();
        /**
         * 100
         * 10
         * [[10,60],[20,30],[30,30],[60,40]]
         */
        int ans = m.minRefuelStops(100,25,new int[][]{{25,25},{50,25},{75,25}});
        System.out.println("Minimum stops:"+ans);
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        // Lets iterate through all stations

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int ans=0;
        if(startFuel >= target)
            return 0;

        if(startFuel < target && stations.length==0)
            return -1;

        if(stations==null || stations.length==0  )
            return 0;


        if(startFuel < stations[0][0]){
            return -1;
        }else{
            startFuel += stations[0][1];
            ans+=1;
        }

        if(startFuel>= target)
            return ans;

        int i =1;

        while(startFuel < target){

            // keep driving until fuel
            while(i < stations.length && startFuel >= stations[i][0]) {

                pq.add(stations[i][1]);
                i++;
            }

            // now your refilling until you reach the next station
            while( i < stations.length && startFuel < stations[i][0] ) {
                startFuel+=pq.poll();
                ans+=1;
            }

            while( i >= stations.length && startFuel < target && !pq.isEmpty()) {
                startFuel+=pq.poll();
                ans+=1;
            }
        }

        if (startFuel>=target)
            return ans;
        else
            return -1;
    }

}
