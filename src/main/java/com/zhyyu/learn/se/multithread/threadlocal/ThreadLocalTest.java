package com.zhyyu.learn.se.multithread.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * test ThreadLocal, reference jdk8 docs
 * @author zhyyu
 *
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
	
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int threadId = get();
					innerMethod(threadId);
				}
			}).start();
		}
		
	}
	
	private static void innerMethod(int outerThreadId) {
		System.out.println("thread id in outerMethod: " + outerThreadId);
		
		int threadId = get();
		System.out.println("thread id in innerMethod: " + threadId);
	}
	
	// Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
        new ThreadLocal<Integer>() {
            @Override protected Integer initialValue() {
                return nextId.getAndIncrement();
        }
    };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }
	
}
