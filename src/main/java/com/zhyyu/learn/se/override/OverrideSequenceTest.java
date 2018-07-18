package com.zhyyu.learn.se.override;

/**
 * 测试重写动态分派顺序(调用第一个实现basicClass 的类的实例方法)
 * 
 * 执行invokevirtual 指令: 查找指向静态类型的实际类型, 递归向上查询, 有则调用实际类型对应方法
 * 
 * @author Administrator
 *
 */
public class OverrideSequenceTest {

	public static void main(String[] args) {
		BasicClass basicClass = new UpClass();
		basicClass.sayHello();
	}
	
	static class BasicClass {

		public void sayHello() {
			System.out.println("basic say hello");
		}
		
	}

	
	static class MidClass extends BasicClass {

		@Override
		public void sayHello() {
			System.out.println("mid say hello");
		}
		
	}
	
	static class UpClass extends MidClass {

		@Override
		public void sayHello() {
			System.out.println("up say hello");
		}
		
	}
	
}
