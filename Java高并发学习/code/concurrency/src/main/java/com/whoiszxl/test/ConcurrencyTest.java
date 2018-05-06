package com.whoiszxl.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whoiszxl.annotations.NotThreadSafe;

/**
 * 线程并发测试
 * @author whoiszxl
 *
 */
@NotThreadSafe
public class ConcurrencyTest {
	
	private static Logger log = LoggerFactory.getLogger(ConcurrencyTest.class);
	//请求总数
	public static int clientTotal = 5000;
	
	//并发执行的线程数
	public static int threadTotal = 200;
	
	public static int count = 0;
	
	private static void add() {
		count++;
	}
	
	public static void main(String[] args) throws InterruptedException {
		//创建一个线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		//计数信号量为200
		final Semaphore semaphore = new Semaphore(threadTotal);
		//线程计数为5000
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i++) {
			executorService.execute(()-> {
				try {
					//从信号量中获取一个允许机会
					semaphore.acquire();
					add();
					//释放允许将占有的信号量归还
					semaphore.release();
				} catch (Exception e) {
					log.error("exception", e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		log.info("count: {}", count);
	}
}
