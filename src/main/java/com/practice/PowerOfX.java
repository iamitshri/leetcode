package com.practice;

public class PowerOfX {

	public static double pow(double x, int n) {

		if (x == 0)
			return 1;

		if (n == 0)
			return 1;

		if (n == 1)
			return x;

		if (n == -1)
			return 1 / x;

		if (n < 0)
			return 1 / x * pow(x, n + 1);

		return x * pow(x, n - 1);

	}

	public static double powEfficient(double x, int n) {

		if (x == 0)
			return 1;

		if (n == 0)
			return 1;

		if (n == 1)
			return x;

		if (n == -1) {
			x = 1 / x;
			n = -n;
		}
		if (n % 2 > 0) {
			return x * pow(x * x, n / 2);
		} else {
			return pow(x * x, n / 2);
		}

	}

	public static void main(String[] args) {
		System.out.println(powEfficient(5, 4));
	}
}
