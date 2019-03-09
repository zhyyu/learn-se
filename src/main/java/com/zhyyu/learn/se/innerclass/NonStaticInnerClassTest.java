package com.zhyyu.learn.se.innerclass;

import com.zhyyu.learn.se.innerclass.NonStaticInnerClassTest.MyObj;

public class NonStaticInnerClassTest {

	private int value1;
	
	private void method1() {
	}
	
	private void method2() {
		// 外部内可以构造内部内
		MyObj myObj = new MyObj();
	}
	
	class MyObj {
		private int innerInvalue1;
		
		private void innerMethod1() {
			// 内部内可以访问外部类成员变量
			int var = value1;
			
			// 内部内可以访问外部类成员变量
			method1();
		}
	}
	
}
