package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null)
			return null;

		LinkedList<List<TreeNode>> result = new LinkedList<List<TreeNode>>();
		LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
		ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		ArrayList<Integer> retCurrent = new ArrayList<Integer>();

		current.add(root);
		retCurrent.add(root.val);

		while (current != null && !current.isEmpty()) {
			result.push(current);
			ret.push(retCurrent);
			List<TreeNode> parents = current;
			current = new ArrayList<TreeNode>();
			retCurrent = new ArrayList<Integer>();
			for (TreeNode n : parents) {
				if (n.left != null) {
					current.add(n.left);
					retCurrent.add(n.left.val);
				}
				if (n.right != null) {
					current.add(n.right);
					retCurrent.add(n.right.val);
				}
			}
		}
		return ret;

	}

	public String tree2str(TreeNode t, String str) {
		if (t == null)
			return str;

		str += "t.val";

		str += "(";
		tree2str(t.left, str);
		str += ")";

		str += "(";
		tree2str(t.right, str);
		return str += ")";

	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(3);
		p.left = new TreeNode(9);
		p.right = new TreeNode(20);

		p.right.left = new TreeNode(15);
		p.right.right = new TreeNode(7);

		LevelOrderTraversal l = new LevelOrderTraversal();
		List<List<Integer>> ret = l.levelOrderBottom(p);
		for (List<Integer> list : ret) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
