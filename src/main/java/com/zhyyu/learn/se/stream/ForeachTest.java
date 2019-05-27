package com.zhyyu.learn.se.stream;

import java.util.Arrays;
import java.util.List;

/**
 * java8 foreach 测试
 * <pre>
 * 1. stream() 会中断之后循环
 * 2. parallelStream() 不会中断之后循环		// 20190527, 依然会中断, 未执行循环不执行, 有随机性
 * 3. parallelStream().forEach 需要等到循环完成后才能执行下条语句
 * <pre>
 * @author Administrator
 *
 */
public class ForeachTest {

	public static void main(String[] args) {
//		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		/*for (Integer integer : intList) {
			printInt(integer);
		}*/
		
		intList.stream().forEach(integer -> printInt(integer));
		System.out.println("stream...");

		intList.parallelStream().forEach(integer -> printInt(integer));
		System.out.println("parallelStream...");
	}
	
	public static void printInt(Integer integer) {
//		if (integer == 3) {
//			throw new RuntimeException();
//		}
		
		System.out.println(integer);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}
	
}
