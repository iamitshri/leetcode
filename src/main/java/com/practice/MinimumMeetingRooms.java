package com.practice;

import java.util.List;
import java.util.PriorityQueue;

class Meeting {

    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MinimumMeetingRooms {


    public static int findMinimumMeetingRoomsAuthor(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0) {
            return 0;
        }

        // sort the meetings by start time
        meetings.sort((a, b) -> Integer.compare(a.start, b.start));

        int minRooms = 0;
        PriorityQueue<Meeting> minHeap =
            new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
        for (Meeting meeting : meetings) {
            // remove all meetings that have ended
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            // add the current meeting into the minHeap
            minHeap.offer(meeting);
            // all active meeting are in the minHeap, so we need rooms for all of them.
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {

        meetings.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Meeting> pq = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
        int rooms = 0;
        for (Meeting meeting : meetings) {

            while (!pq.isEmpty() && meeting.start >= pq.peek().end) {
                pq.poll();
            }
            pq.offer(meeting);
            rooms = Math.max(rooms, pq.size());
        }
        return rooms;
    }

    public static void main(String[] args) {
        List<Meeting> input = List.of(new Meeting(4, 5), new Meeting(2, 3), new Meeting(2, 4), new Meeting(3, 5));
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = List.of(new Meeting(1, 4), new Meeting(2, 5), new Meeting(7, 9));
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = List.of(new Meeting(6, 7), new Meeting(2, 4), new Meeting(8, 12));
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = List.of(new Meeting(1, 4), new Meeting(2, 3), new Meeting(3, 6));
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = List.of(new Meeting(4, 5), new Meeting(2, 3), new Meeting(2, 4), new Meeting(3, 5));
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
