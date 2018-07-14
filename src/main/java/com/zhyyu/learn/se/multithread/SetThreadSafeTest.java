package com.zhyyu.learn.se.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * set 方法是否线程安全, 无论是否设置volatile
 * <pre>
 * 
  private static int getI();
    descriptor: ()I
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=1, locals=0, args_size=0
         0: getstatic     #40                 // Field i:I
         3: ireturn
      LineNumberTable:
        line 14: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature

  private static void setI(int);
    descriptor: (I)V
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=1, locals=1, args_size=1
         0: iload_0
         1: putstatic     #40                 // Field i:I
         4: return
      LineNumberTable:
        line 18: 0
        line 19: 4
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0     i   I
   	异常路径:
   	1. 线程1 执行load
   	2. 线程2 执行putstatic 方法
   	3. 线程1 执行putstatic 方法, 覆盖线程2 执行过的putstaic  方法
   	ps: 是否设置volatile 一样结果, 设置volatile 仅保证getstatic 获取的是其他线程同步的方法, 但java 代码对应的是多个jvm 命令                      
 * @author zhyyu
 *
 */
public class SetThreadSafeTest {

	private static int i = 0;
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch doneSignal = new CountDownLatch(100);
		Executor e = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; ++i) {
			e.execute(new IncrementTask(doneSignal));
		}

		doneSignal.await(); // wait for all to finish
		
		// assume 10000(100*100) but not
		System.out.println(i);
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		SetThreadSafeTest.i = i;
	}
	
	public static void incrementI() {
		int i2 = getI();
		setI(i2 + 1);
	}
	
	static class IncrementTask implements Runnable {
		private final CountDownLatch doneSignal;

		IncrementTask(CountDownLatch doneSignal) {
			this.doneSignal = doneSignal;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				incrementI();
			}
			doneSignal.countDown();
		}
		
	}
	
}
