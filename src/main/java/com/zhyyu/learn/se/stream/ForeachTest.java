package com.zhyyu.learn.se.stream;

import java.util.Arrays;
import java.util.List;

/**
 * java8 foreach 测试
 * <pre>
 * 1. stream() 会中断之后循环
 * 2. parallelStream() 不会中断之后循环
 * <pre>
 * @author Administrator
 *
 */
public class ForeachTest {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		/*for (Integer integer : intList) {
			printInt(integer);
		}*/
		
		intList.stream().forEach(integer -> printInt(integer));
		intList.parallelStream().forEach(integer -> printInt(integer));
	}
	
	public static void printInt(Integer integer) {
		if (integer == 3) {
			throw new RuntimeException();
		}
		
		System.out.println(integer);
	}
	
}
