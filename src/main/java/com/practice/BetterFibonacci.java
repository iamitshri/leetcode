package com.practice;

public class BetterFibonacci {
	public static int betterFibonacci(int n) {
		// 0 1 1 2 3 5 8 13
		if (n == 0 || n == 1) {
			return 1;
		}
		int fib = 0;
		int n_1 = 1;
		int n_2 = 0;

		for (int i = 2; i <= n; i++) {
			fib = n_2 + n_1;
			n_2 = n_1;
			n_1 = fib;

		}
		return fib;
	}

	public static void main(String[] args) {
		System.out.println(betterFibonacci(3));
	}

}
