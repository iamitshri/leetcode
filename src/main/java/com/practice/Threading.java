package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading {
	static int x = 10;

	public static void main(String[] args) {
		ExecutorService svc = Executors.newCachedThreadPool();
		for (int i = 12; i > 0; i--) {
			svc.execute(new Runnable() {

				@Override
				public void run() {

					x++;
				}
			});

		}
		svc.shutdown();
		System.out.println(x);
	}

}
