package com.zhyyu.learn.se.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * test if oom effect other thread.
 * CON: oom thread will out effect other thread
 * 
 * -Xms10m -Xmx10m
 * @author zhyyu
 *
 * <br>
 * output:
 * <pre>
thread1 is running...
thread2 is running...
thread1 is running...
thread2 is running...
thread2 is running...
thread1 is running...
thread2 is running...
thread1 is running...
thread1 is running...
thread2 is running...
thread1 is running...
thread2 is running...
thread2 is running...
thread1 is running...
Exception in thread "oomThread1" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:265)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
	at java.util.ArrayList.add(ArrayList.java:462)
	at com.zhyyu.learn.jvm.oomsof.WillOOMEffectOtherThreadTest$3.run(WillOOMEffectOtherThreadTest.java:92)
	at java.lang.Thread.run(Thread.java:748)
thread1 is running...
thread2 is running...
thread2 is running...
thread1 is running...
thread1 is running...
thread2 is running...
thread1 is running...
thread2 is running...
thread1 is running...
thread2 is running...
thread2 is running...
thread1 is running...


 *
 */
public class WillOOMEffectOtherThreadTest {

	public static void main(String[] args) throws InterruptedException {
		
		Thread normalThread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("thread1 is running...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		normalThread1.setName("normalThread1");
		
		Thread normalThread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("thread2 is running...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		normalThread2.setName("normalThread2");
		
		Thread oomThread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				List<Integer> intList = new ArrayList<Integer>();
				
				while (true) {
					Random random = new Random();
					intList.add(new Integer(random.nextInt(Integer.MAX_VALUE)));
				}
			}
		});
		oomThread1.setName("oomThread1");
		
		normalThread1.start();
		normalThread2.start();
		
		Thread.sleep(3000);
		oomThread1.start();
		
	}
	
}
