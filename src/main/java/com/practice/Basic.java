package com.practice;

import java.lang.reflect.Method;

class A {
	A(int c) {
		System.out.println(c);

	}

	A() {

	}

	void print() {
		System.out.println("how are you amit. Is reflection good for you?");
	}

	protected int i = 12;

}

class B extends A {
	static int a = 12;

	B(int i) {
		this();
		System.out.println("constructor:" + this.i);
	}

	B() {
		super(12);
	}
}

public class Basic {
	public static void main(String[] args) throws Exception {
		A a = new A();
		A b = new B(0);
		System.out.println(b.i);

		Class x = Class.forName("com.practice.A");
		Object o = x.newInstance();

		Method m = x.getDeclaredMethod("print", null);
		m.invoke(o, null);
		System.out.println(x.getClassLoader());

	}
}
