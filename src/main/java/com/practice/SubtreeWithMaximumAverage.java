package com.practice;

class NaryTreeNode {

    NaryTreeNode[] children;
    int val;
}

public class SubtreeWithMaximumAverage {


    double max = Integer.MIN_VALUE;
    NaryTreeNode maxNode = null;

    public NaryTreeNode maximumAverageSubtree(NaryTreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return maxNode;
    }

    private double[] helper(NaryTreeNode root) {
        if (root == null) {
            return new double[]{0, 0};
        }

        double curTotal = root.val;
        double count = 1;
        for (NaryTreeNode child : root.children) {
            double[] cur = helper(child);
            curTotal += cur[0];
            count += cur[1];
        }
        double avg = curTotal / count;
        if (count > 1 && avg > max) { //taking "at least 1 child" into account
            max = avg;
            maxNode = root;
        }
        return new double[]{curTotal, count};
    }

}
