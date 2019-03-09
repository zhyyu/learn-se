package com.zhyyu.learn.se.override;

/**
 * 重写基类静态方法测试
 * <pre>
 * 1. 可以语法上"重写"
 * 2. 但语义上, 父类引用子类实现, 父类调用子父类共有静态方法, 实际调用父类静态方法, 不为重写
 * @author zhyyu
 *
 */
public class OverrideStaticMethodTest {

	public static void main(String[] args) {
		BaseObj baseObj = new SubObj();
		baseObj.method1();
		// output: BaseObj
	}
	
	static class BaseObj {
		static void method1() {
			System.out.println("BaseObj");
		}
	}
	
	static class SubObj extends BaseObj {
		static void method1() {
			System.out.println("SubObj");
		}
	}
	
}
