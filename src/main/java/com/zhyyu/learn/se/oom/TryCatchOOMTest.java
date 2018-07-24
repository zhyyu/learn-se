package com.zhyyu.learn.se.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * -Xms10m -Xmx10m
 * <br>
 * CON: cannot try catch oom
 * @author zhyyu
 *
 */
public class TryCatchOOMTest {

	public static void main(String[] args) {
		try {
			oomMethod();
		} catch (Exception e) {
			System.out.println("catch the oom!!!");
			e.printStackTrace();
		}
	}
	
	public static void oomMethod() {
		List<Integer> intList = new ArrayList<Integer>();
		
		while (true) {
			Random random = new Random();
			intList.add(new Integer(random.nextInt(Integer.MAX_VALUE)));
		}
	}
	
}


//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//at java.util.Arrays.copyOf(Arrays.java:3210)
//at java.util.Arrays.copyOf(Arrays.java:3181)
//at java.util.ArrayList.grow(ArrayList.java:265)
//at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
//at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
//at java.util.ArrayList.add(ArrayList.java:462)
//at com.zhyyu.learn.jvm.oomsof.TryCatchOOMTest.oomMethod(TryCatchOOMTest.java:28)
//at com.zhyyu.learn.jvm.oomsof.TryCatchOOMTest.main(TryCatchOOMTest.java:16)
