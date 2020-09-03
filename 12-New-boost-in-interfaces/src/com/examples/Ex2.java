package com.examples;

interface I1 {
	void a();

	default void b() {
	}
}

interface I2 {
	void a();

	default void b() {
	}
}

class C implements I1, I2 {
	@Override
	public void a() {

	}

	@Override
	public void b() {
		I1.super.b();
		I2.super.b();
	}
}

public class Ex2 {

	public static void main(String[] args) {

	}

}
