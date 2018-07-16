package com.zhyyu.learn.se.multithread.threadlocal;

import java.util.UUID;

/**
 * {@link https://dzone.com/articles/painless-introduction-javas-threadlocal-storage}
 * @author zhyyu
 *
 */
public class TransactionManager {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					startTransaction();
					String transactionId = getTransactionId();
					System.out.println("start transaction, transactionId: " + transactionId);
					endTransaction();
					System.out.println("end transaction");
				}
			}).start();
		}
	}

	private static final ThreadLocal<String> context = new ThreadLocal<String>();

	public static void startTransaction() {
		// logic to start a transaction
		// ...
		String generatedId = UUID.randomUUID().toString();
		context.set(generatedId);
	}

	public static String getTransactionId() {
		return context.get();
	}

	public static void endTransaction() {
		// logic to end a transaction
		// …
		context.remove();
	}

}
