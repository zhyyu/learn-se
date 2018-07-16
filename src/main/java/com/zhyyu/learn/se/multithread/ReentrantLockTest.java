package com.zhyyu.learn.se.multithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author zhyyu
 *
 */
public class ReentrantLockTest {
 
	public static void main(String[] args) {
		synchronousMethod();
	}
	
	private static void synchronousMethod() {
		ReentrantLock reentrantLock = new ReentrantLock();
		
		// 1. reentrantLock can set fair strategy
		// ReentrantLock reentrantLock = new ReentrantLock(true);
		
		// 2. reentrantLock can set wait timeout 
		// reentrantLock.tryLock(1, TimeUnit.SECONDS);
		
		reentrantLock.lock();
		try {
			System.out.println("reentrantLock test");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reentrantLock.unlock();
		}
	}
	
}
