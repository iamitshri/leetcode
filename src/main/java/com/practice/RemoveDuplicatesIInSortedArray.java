package com.practice;

public class RemoveDuplicatesIInSortedArray {

	public static int removeDuplicates(int[] a) {
		if (a == null || a.length == 0)
			return 0;
		int j = 0;
		// 1 2 3
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[j] != a[i]) {
				a[++j] = a[i];
			}
		}
		return j + 1;
	}

	public static void main(String[] args) {
		int[] i = new int[] { 1, 2 };
		int n = removeDuplicates(i);
		System.out.println(n);

	}
}
