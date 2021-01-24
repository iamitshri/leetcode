package com.practice;

class HammingDistance {
	/**
	 * 
	 * The Hamming distance between two integers is the number of positions at
	 * which the corresponding bits are different.
	 * 
	 * Given two integers x and y, calculate the Hamming distance.
	 * 
	 * Note: 0 ≤ x, y < 231.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 32; i++) {

			if (((x >> i & 1) ^ (y >> i & 1)) == 1) {
				cnt++;
			}

		}

		return cnt;
	}

	static int cntOnes(int x) {
		int cnt = 0;
		while (x != 0) {
			x = x & x - 1;
			cnt++;
		}
		return cnt;
	}

	public int hammingDistance2(int x, int y) {
		int cnt = 0;

		for (int i = 0; i < 32; i++) {
			if (((x >> i) & 1) != ((y >> i) & 1)) {
				cnt++;
			}
		}
		return cnt;
	}

	public static int findComplement(int num) {

		// find the 1st set bit
		// and with
		int firstSetBit = 0;
		for (int i = 31; i >= 0; i--) {
			if ((num >> i) == 1) {
				firstSetBit = i;
				break;
			}
		}
		int temp = 0;
		for (int i = 31; i >= 0; i--) {
			if (i <= firstSetBit) {
				temp |= 1 << i;
			}
		}
		// System.out.println(temp);
		int ret = ~num & temp;
		return ret;
	}

	public static int findComplement2(int num) {

		int temp = (Integer.highestOneBit(num) << 1) - 1;
		int ret = ~num & temp;
		return ret;
	}

	public static void main(String[] s) {
		System.out.println(findComplement2(0));
	}
}
