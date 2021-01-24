package com.practice;

public class BitOperations {
	/**
	 * Count number of bits
	 * 
	 * @param a
	 * @return
	 */
	static public int numSetBits(long a) {
		int cnt = 0;
		for (int i = 0; i < 32; i++) {
			if (((a >> i) & 1) == 1) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.err.println(numSetBits(1));
	}

}
