package com.zhyyu.learn.se.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * test unmodifiable collection
 * 
 * <br>
 * OUTPUT:
 * <pre>
 * [1, 2, 3]
[1, 2, 3]
[1, 2, 3, 4]
[1, 2, 3, 4]
Exception in thread "main" java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at com.zhyyu.learn.se.collection.UnmodifiableCollectionTest.main(UnmodifiableCollectionTest.java:22)

	<br>
CON:
Collections.unmodifiableCollection 返回collection 视图, 不可编辑或修改, 但可以试试查看原 collection 变化

 * @author Administrator
 *
 */
public class UnmodifiableCollectionTest {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println(intList);
		
		Collection<Integer> unmodifiableIntList = Collections.unmodifiableCollection(intList);
		System.out.println(unmodifiableIntList);
		
		intList.add(4);
		System.out.println(intList);
		System.out.println(unmodifiableIntList);
		
		unmodifiableIntList.add(5);
		System.out.println(intList);
		System.out.println(unmodifiableIntList);
	}
	
}
