package com.zhyyu.learn.se.overload;

/**
 * 测试重载
 * <pre>
 * 方法名相同, 参数基类相同, 调用重载方法
 * 1. 优先调用参数类型一致的方法
 * 2. 若无参数一致方法, 查找参数类型父类类型发放
 * @author zhyyu2016
 *
 */
public class OverloadTest {

	public static void main(String[] args) {
		BasicClass basicClass = new BasicClass();
		sayHello(basicClass);
		
		ExtendClass extendClass = new ExtendClass();
		sayHello(extendClass);
	}
	
	public static void sayHello(BasicClass basicClass) {
		System.out.println("basicClass say hello");
	}
	
	public static void sayHello(ExtendClass extendClass) {
		System.out.println("extendClass say hello");
	}
	
	static class BasicClass {
	}
	
	static class ExtendClass extends BasicClass {
	}
	
}
