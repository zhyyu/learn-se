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



//java.lang.UnsupportedOperationException
//at java.util.AbstractList.add(AbstractList.java:148)
//at java.util.AbstractList.add(AbstractList.java:108)
//at com.zhyyu.learn.se.collection.ArraysAsListTest.main(ArraysAsListTest.java:17)
//java.lang.UnsupportedOperationException
//at java.util.AbstractList.remove(AbstractList.java:161)
//at java.util.AbstractList$Itr.remove(AbstractList.java:374)
//at java.util.AbstractCollection.remove(AbstractCollection.java:293)
//at com.zhyyu.learn.se.collection.ArraysAsListTest.main(ArraysAsListTest.java:24)
//[1, 2, 3]
//[1, 2, 3]
//[1, 2, 3, 4]
//[2, 3, 4]

