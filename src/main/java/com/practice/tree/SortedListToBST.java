package com.practice.tree;

import com.practice.linkedlist.ListNode;

public class SortedListToBST {




    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    ListNode head;

    public TreeNode sortedListToBST(ListNode h) {

        if (h == null) {
            return null;
        }

        int count = countNodes(h);

        head = h;

        return helper(count);

    }

    public TreeNode helper(int n) {

        if (n <= 0) {
            return null;
        }

        TreeNode left = helper(n / 2);

        TreeNode root = new TreeNode(head.val);
        head = head.next;

        TreeNode right = helper(n - (n / 2) - 1);

        root.left = left;
        root.right = right;
        return root;

    }

    int countNodes(ListNode head) {
        if (head == null) {
            return 0;
        }
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}
