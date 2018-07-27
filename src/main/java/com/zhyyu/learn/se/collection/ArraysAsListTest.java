package com.zhyyu.learn.se.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * test Arrays.asList
 * @author Administrator
 *
 */
public class ArraysAsListTest {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3);
		try {
			intList.add(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(intList);
		
		try {
			intList.remove(new Integer(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(intList);
		
		/* ========================== wrap fixed-size list ============================*/
		ArrayList<Integer> newIntList = new ArrayList<>(Arrays.asList(1, 2, 3));
		try {
			newIntList.add(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(newIntList);
		
		try {
			newIntList.remove(new Integer(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(newIntList);
	}
	
}
