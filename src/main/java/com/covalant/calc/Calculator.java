package com.covalant.calc;

public class Calculator {

	public Calculator(int a) {
		System.out.println("in one argument constructor " + a);
	}

	public Calculator() {
		System.out.println("in zero argument constructor ");
	}

	public void add1() {
		int a = 20;
		int b = 30;
		int c = a + b;
		System.out.println(c);
	}

	public int add(int a, int b) {
		int c = a + b;
		return c;
	}

	public void avg(int a) {
		int d = a / 2;
		System.out.println(d);
	}

	public int add3(int a, int b) {
		int c = a + b;
		System.out.println(c);
		return c;
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.add1();
	}
}
