package com.practice.linkedlist;

import ListNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumberII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode list = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            sum /= 10;

            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = list;
            list = newNode;
        }

        if (sum / 10 == 1) {
            ListNode newNode = new ListNode(sum / 10);
            newNode.next = list;
            list = newNode;
        }
        return list;
    }
}
