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

	// solution 1: use synchronized
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



//F:\workspace-zhyyu-learn\learn-se\target\classes\com\zhyyu\learn\se\multithread>javap -p -v VolatileTest.class
//Classfile /F:/workspace-zhyyu-learn/learn-se/target/classes/com/zhyyu/learn/se/multithread/VolatileTest.class
//  Last modified 2018-7-18; size 1446 bytes
//  MD5 checksum 9732ebd1d412aa505b18ea2ff1795244
//  Compiled from "VolatileTest.java"
//public class com.zhyyu.learn.se.multithread.VolatileTest
//  minor version: 0
//  major version: 52
//  flags: ACC_PUBLIC, ACC_SUPER
//Constant pool:
//   #1 = Class              #2             // com/zhyyu/learn/se/multithread/VolatileTest
//   #2 = Utf8               com/zhyyu/learn/se/multithread/VolatileTest
//   #3 = Class              #4             // java/lang/Object
//   #4 = Utf8               java/lang/Object
//   #5 = Utf8               num
//   #6 = Utf8               I
//   #7 = Utf8               <clinit>
//   #8 = Utf8               ()V
//   #9 = Utf8               Code
//  #10 = Fieldref           #1.#11         // com/zhyyu/learn/se/multithread/VolatileTest.num:I
//  #11 = NameAndType        #5:#6          // num:I
//  #12 = Utf8               LineNumberTable
//  #13 = Utf8               LocalVariableTable
//  #14 = Utf8               <init>
//  #15 = Methodref          #3.#16         // java/lang/Object."<init>":()V
//  #16 = NameAndType        #14:#8         // "<init>":()V
//  #17 = Utf8               this
//  #18 = Utf8               Lcom/zhyyu/learn/se/multithread/VolatileTest;
//  #19 = Utf8               increaseNum
//  #20 = Utf8               main
//  #21 = Utf8               ([Ljava/lang/String;)V
//  #22 = Utf8               Exceptions
//  #23 = Class              #24            // java/lang/InterruptedException
//  #24 = Utf8               java/lang/InterruptedException
//  #25 = Class              #26            // java/util/concurrent/CountDownLatch
//  #26 = Utf8               java/util/concurrent/CountDownLatch
//  #27 = Methodref          #25.#28        // java/util/concurrent/CountDownLatch."<init>":(I)V
//  #28 = NameAndType        #14:#29        // "<init>":(I)V
//  #29 = Utf8               (I)V
//  #30 = Methodref          #31.#33        // java/util/concurrent/Executors.newCachedThreadPool:()Ljava/util/concurrent/ExecutorService;
//  #31 = Class              #32            // java/util/concurrent/Executors
//  #32 = Utf8               java/util/concurrent/Executors
//  #33 = NameAndType        #34:#35        // newCachedThreadPool:()Ljava/util/concurrent/ExecutorService;
//  #34 = Utf8               newCachedThreadPool
//  #35 = Utf8               ()Ljava/util/concurrent/ExecutorService;
//  #36 = Class              #37            // com/zhyyu/learn/se/multithread/VolatileTest$WorkerRunnable
//  #37 = Utf8               com/zhyyu/learn/se/multithread/VolatileTest$WorkerRunnable
//  #38 = Methodref          #36.#39        // com/zhyyu/learn/se/multithread/VolatileTest$WorkerRunnable."<init>":(Ljava/util/concurrent/CountDownLatch
//;)V
//  #39 = NameAndType        #14:#40        // "<init>":(Ljava/util/concurrent/CountDownLatch;)V
//  #40 = Utf8               (Ljava/util/concurrent/CountDownLatch;)V
//  #41 = InterfaceMethodref #42.#44        // java/util/concurrent/Executor.execute:(Ljava/lang/Runnable;)V
//  #42 = Class              #43            // java/util/concurrent/Executor
//  #43 = Utf8               java/util/concurrent/Executor
//  #44 = NameAndType        #45:#46        // execute:(Ljava/lang/Runnable;)V
//  #45 = Utf8               execute
//  #46 = Utf8               (Ljava/lang/Runnable;)V
//  #47 = Methodref          #25.#48        // java/util/concurrent/CountDownLatch.await:()V
//  #48 = NameAndType        #49:#8         // await:()V
//  #49 = Utf8               await
//  #50 = Fieldref           #51.#53        // java/lang/System.out:Ljava/io/PrintStream;
//  #51 = Class              #52            // java/lang/System
//  #52 = Utf8               java/lang/System
//  #53 = NameAndType        #54:#55        // out:Ljava/io/PrintStream;
//  #54 = Utf8               out
//  #55 = Utf8               Ljava/io/PrintStream;
//  #56 = Methodref          #57.#59        // java/io/PrintStream.println:(I)V
//  #57 = Class              #58            // java/io/PrintStream
//  #58 = Utf8               java/io/PrintStream
//  #59 = NameAndType        #60:#29        // println:(I)V
//  #60 = Utf8               println
//  #61 = Utf8               args
//  #62 = Utf8               [Ljava/lang/String;
//  #63 = Utf8               doneSignal
//  #64 = Utf8               Ljava/util/concurrent/CountDownLatch;
//  #65 = Utf8               e
//  #66 = Utf8               Ljava/util/concurrent/Executor;
//  #67 = Utf8               i
//  #68 = Utf8               StackMapTable
//  #69 = Utf8               SourceFile
//  #70 = Utf8               VolatileTest.java
//  #71 = Utf8               InnerClasses
//  #72 = Utf8               WorkerRunnable
//{
//  public static volatile int num;
//    descriptor: I
//    flags: ACC_PUBLIC, ACC_STATIC, ACC_VOLATILE
//
//  static {};
//    descriptor: ()V
//    flags: ACC_STATIC
//    Code:
//      stack=1, locals=0, args_size=0
//         0: iconst_0
//         1: putstatic     #10                 // Field num:I
//         4: return
//      LineNumberTable:
//        line 15: 0
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//
//  public com.zhyyu.learn.se.multithread.VolatileTest();
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=1, locals=1, args_size=1
//         0: aload_0
//         1: invokespecial #15                 // Method java/lang/Object."<init>":()V
//         4: return
//      LineNumberTable:
//        line 13: 0
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//            0       5     0  this   Lcom/zhyyu/learn/se/multithread/VolatileTest;
//
//  public static void increaseNum();
//    descriptor: ()V
//    flags: ACC_PUBLIC, ACC_STATIC
//    Code:
//      stack=2, locals=0, args_size=0
//         0: getstatic     #10                 // Field num:I
//         3: iconst_1
//         4: iadd
//         5: putstatic     #10                 // Field num:I
//         8: return
//      LineNumberTable:
//        line 20: 0
//        line 21: 8
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//
//  public static void main(java.lang.String[]) throws java.lang.InterruptedException;
//    descriptor: ([Ljava/lang/String;)V
//    flags: ACC_PUBLIC, ACC_STATIC
//    Exceptions:
//      throws java.lang.InterruptedException
//    Code:
//      stack=4, locals=4, args_size=1
//         0: new           #25                 // class java/util/concurrent/CountDownLatch
//         3: dup
//         4: bipush        100
//         6: invokespecial #27                 // Method java/util/concurrent/CountDownLatch."<init>":(I)V
//         9: astore_1
//        10: invokestatic  #30                 // Method java/util/concurrent/Executors.newCachedThreadPool:()Ljava/util/concurrent/ExecutorService;
//        13: astore_2
//        14: iconst_0
//        15: istore_3
//        16: goto          36
//        19: aload_2
//        20: new           #36                 // class com/zhyyu/learn/se/multithread/VolatileTest$WorkerRunnable
//        23: dup
//        24: aload_1
//        25: invokespecial #38                 // Method com/zhyyu/learn/se/multithread/VolatileTest$WorkerRunnable."<init>":(Ljava/util/concurrent/Cou
//ntDownLatch;)V
//        28: invokeinterface #41,  2           // InterfaceMethod java/util/concurrent/Executor.execute:(Ljava/lang/Runnable;)V
//        33: iinc          3, 1
//        36: iload_3
//        37: bipush        100
//        39: if_icmplt     19
//        42: aload_1
//        43: invokevirtual #47                 // Method java/util/concurrent/CountDownLatch.await:()V
//        46: getstatic     #50                 // Field java/lang/System.out:Ljava/io/PrintStream;
//        49: getstatic     #10                 // Field num:I
//        52: invokevirtual #56                 // Method java/io/PrintStream.println:(I)V
//        55: return
//      LineNumberTable:
//        line 31: 0
//        line 32: 10
//        line 34: 14
//        line 35: 19
//        line 34: 33
//        line 38: 42
//        line 41: 46
//        line 42: 55
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//            0      56     0  args   [Ljava/lang/String;
//           10      46     1 doneSignal   Ljava/util/concurrent/CountDownLatch;
//           14      42     2     e   Ljava/util/concurrent/Executor;
//           16      26     3     i   I
//      StackMapTable: number_of_entries = 2
//        frame_type = 254 /* append */
//          offset_delta = 19
//          locals = [ class java/util/concurrent/CountDownLatch, class java/util/concurrent/Executor, int ]
//        frame_type = 16 /* same */
//}
//SourceFile: "VolatileTest.java"
//InnerClasses:
//     static #72= #36 of #1; //WorkerRunnable=class com/zhyyu/learn/se/multithread/VolatileTest$WorkerRunnable of class com/zhyyu/learn/se/multithread/
//VolatileTest
