package com.practice;

/**
 * 
 * 
 * 
 * Input: Binary tree: [1,2,3,4] 1 / \ 2 3 / 4
 * 
 * Output: "1(2(4))(3)"
 * 
 * @author amitss28
 *
 */
public class TreeToStr {
	public String tree2str(TreeNode t) {
		if (t == null)
			return "";
		String str = "" + t.val;
		if (t.left == null && t.right == null) {
			return str;
		}
		// if (t.left != null) {
		str += "(";
		str += tree2str(t.left);
		str += ")";
		// }
		if (t.right != null) {
			str += "(";
			str += tree2str(t.right);
			str += ")";
		}
		return str;
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		p.left.right = new TreeNode(4);

		// p.right.left = new TreeNode(15);
		// p.right.right = new TreeNode(7);

		TreeToStr t = new TreeToStr();
		System.out.println(t.tree2str(p));

	}
}
