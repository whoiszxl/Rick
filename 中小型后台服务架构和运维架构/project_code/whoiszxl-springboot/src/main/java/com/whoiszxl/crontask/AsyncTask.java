package com.whoiszxl.crontask;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * 异步任务
 * @author whoiszxl
 *
 */
@Component
public class AsyncTask {

	//@Async修饰的函数不能用static
	
	//异步回调,不返回数据
	@Async
	public void dealNotReturnTask() {
		System.out.println("Thread {} deal no return task start     "+Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread {} deal no return task end     "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
	}
	
	
	//异步回调,返回数据
	@Async
	public Future<String> dealHaveReturnTask() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AsyncResult<String>("异步回调返回数据");
	}

}
