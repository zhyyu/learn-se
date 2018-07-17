package com.zhyyu.learn.se.multithread.threadlocal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

/**
 * {@link https://dzone.com/articles/painless-introduction-javas-threadlocal-storage}
 * @author zhyyu
 *
 */
public class ThreadLocalWithThreadPool {
	
	private static final ThreadLocal<String> context = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return UUID.randomUUID().toString();
		};
	};
	
	private static ExecutorService threadPool = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(1000));
	
	private static List<String> threadUUIDList = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			threadPool.submit(new Runnable() {
				@Override
				public void run() {
					String threadUUID = context.get();
					System.out.println("thread uuid: " + threadUUID);
					if (StringUtils.isBlank(threadUUID)) {
						System.out.println("threal local not set");
						return;
					}
					
					boolean contains = threadUUIDList.contains(threadUUID);
					if (contains) {
						System.out.println("reuse old thread");
						return;
					}
					
					threadUUIDList.add(threadUUID);
					
					// 若要ThreadLocal 兼容 threadPool, 需要在线程使用完成后清理线程对应threadLocal value
					// context.remove();
				}
			});
		}
		
		Thread.sleep(2000);
		System.out.println("threadUUIDList size: " + threadUUIDList.size());
	}
	
}
