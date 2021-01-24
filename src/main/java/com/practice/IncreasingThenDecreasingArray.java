package com.practice;

public class IncreasingThenDecreasingArray {

	/**
	 * 
	 * 11 22 33 44 55 66 60 50 40 30 20 10 66 is the one we need to find
	 * 
	 * @param key
	 * @return
	 */
	static int findElement(int[] a) {
		if (a == null || a.length <= 2)
			return -1;
		int l = 0;
		int h = a.length - 1;

		while (l < h) {
			int m = l + (h - l) / 2;
			if (a[m] > a[m + 1] && a[m] > a[m - 1]) {
				return m;
			} else if (a[m] > a[m + 1]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	/**
	 * 
	 * 11 22 33 44 55 66 60 50 40 30 20 10 66 is the one we need to find
	 * 
	 * @param key
	 * @return
	 */
	static int findElement(int[] a, int key) {
		if (a == null || a.length <= 2)
			return -1;
		int l = 0;
		int h = a.length - 1;

		while (l < h) {
			int m = l + (h - l) / 2;

			if (a[m] > a[m + 1] && a[m] > a[m - 1]) {
				return m;
			} else if (a[m] > a[m + 1]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findElement(new int[] { -2, 0, -1 }));
	}
}
