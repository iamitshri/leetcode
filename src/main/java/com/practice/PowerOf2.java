package com.practice;

public class PowerOf2 {
	public static boolean isPowOfTwo(int num) {
		return ((num & num - 1) == 0);
	}
}
