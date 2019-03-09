package com.zhyyu.learn.se.innerclass;

public class StaticInnerClassTest {
	private int value1;
	
	private void method1() {
	}
	
	private void method2() {
		// 外部内可以构造内部内
		MyObj myObj = new MyObj();
	}
	
	static class MyObj {
		private int innerInvalue1;
		
		private void innerMethod1() {
			// **静态**内部内**不**可以访问外部类成员变量(编译报错)
			// int var = value1;
			
			// **静态**内部内**不**可以访问外部类成员变量(编译报错)
			// method1();
		}
	}
}
