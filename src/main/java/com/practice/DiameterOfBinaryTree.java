package com.practice;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfBinaryTree {
	int dia = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 0;
		}
		dia(root);

		return dia;
	}

	public int dia(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int left = dia(root.left);
		int right = dia(root.right);
		dia = Math.max(dia, left + right);
		return 1 + Math.max(left, right);
	}
	
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.get(4);
		System.exit(0);
	}
}
