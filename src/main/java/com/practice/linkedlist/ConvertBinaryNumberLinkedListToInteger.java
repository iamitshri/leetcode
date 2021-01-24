package com.practice.linkedlist;


public class ConvertBinaryNumberLinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result << 1 | head.val;
            head = head.next;
        }
        return result;
    }
}
