package com.zhyyu.learn.se.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * volatile test, volatile 修饰变量对其他线程可见, 但num = num + 1 指令不是原子性操作, 故会少加数
 * exp: 如num = 9 , 一个线程读 执行 num + 1, 另一个线程也执行num + 1, 第一个线程写num = 10, 第二个线程也写num = 10, 故少加一次
 * @author zhyyu
 *
 */
public class VolatileTest {

	public static volatile int num = 0;

	// solution2: use synchronized
	// public static synchronized void increaseNum() {
	public static void increaseNum() {
		num = num + 1;
	}
	
	// solution 2: use AtomicInteger
	/*public static volatile AtomicInteger num = new AtomicInteger(0);

	public static void increaseNum() {
		num.addAndGet(1);
	}*/
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch doneSignal = new CountDownLatch(100);
		Executor e = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; ++i) {
			e.execute(new WorkerRunnable(doneSignal));
		}

		doneSignal.await(); // wait for all to finish
		
		// assume 10000(100*100) but not
		System.out.println(num);
	}

	static class WorkerRunnable implements Runnable {
		private final CountDownLatch doneSignal;

		WorkerRunnable(CountDownLatch doneSignal) {
			this.doneSignal = doneSignal;
		}

		public void run() {
			for (int i = 0; i < 100; ++i) {
				increaseNum();
			}
			doneSignal.countDown();
		}

	}

}
