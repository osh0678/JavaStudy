package com.javalec.ex;


public class lamda {

	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("hi");
		}).start();
		
		
		Func add = (int a, int b) -> a+b;
		
		System.out.println(add.calc(3, 5));

		Func sub = (int a, int b) -> a-b;
		
		Func add2 = (int a, int b) -> { return a + b; };
		
		
		System.out.println(sub.calc(5, 3));
		
		System.out.println(add2.calc(5, 3));
	}
	
	@FunctionalInterface
	interface Func{
		public int calc(int a, int b);
	}
}
