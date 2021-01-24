package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

	ArrayList<LinkedList<TreeNode>> getListOfDepths(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		if (root == null) {
			return result;
		}

		// current and parent
		/**
		 * In one stroke add all the children of level into a linkedlist.
		 * 
		 * Initially current will be root. i.e. level 1 add all childrens into
		 * LL
		 * 
		 * 1 2 3
		 * 
		 * 4 5 6 7
		 * 
		 */
		LinkedList<TreeNode> current = new LinkedList<>();
		current.add(root);
		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<>();
			for (TreeNode tn : parents) {
				if (tn.left != null) {
					current.add(tn.left);
				}
				if (tn.right != null) {
					current.add(tn.right);
				}
			}
		}

		return result;
	}
}
