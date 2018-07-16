package com.zhyyu.learn.se.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition test reference jdk8 docs
 * @author Administrator
 *
 */
public class ConditionTest {

	final static Lock lock = new ReentrantLock();
	final static Condition notFull = lock.newCondition();
	final static Condition notEmpty = lock.newCondition();

	final static Object[] items = new Object[10];
	static int putptr, takeptr, count;
	
	public static void main(String[] args) throws InterruptedException {
		Thread putThread = new Thread(new PutTask());
		putThread.start();
		
		System.out.println("takeThread start in 10s...");
		Thread.sleep(10000);
		System.out.println("takeThread starting...");
		
		Thread takeThread = new Thread(new TakeTask());
		takeThread.start();
		
		while (true);
	}
	
	static class PutTask implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					put (i);
					System.out.println("PutTask put " + i  +" into buffer");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	static class TakeTask implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Object i = take();
					System.out.println("TaskTask take " + i + " from buffer");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public static Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}

}
