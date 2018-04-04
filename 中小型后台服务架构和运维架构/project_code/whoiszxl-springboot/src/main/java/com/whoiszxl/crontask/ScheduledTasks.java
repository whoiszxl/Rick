package com.whoiszxl.crontask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.whoiszxl.service.StarRepositoryService;

/**
 * 定时任务
 * @author whoiszxl
 *
 */
@Component
public class ScheduledTasks {

	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private StarRepositoryService repositoryService;
	
	@Scheduled(fixedRate=3000)
	/**
	 * @Scheduled(fixedRate=3000) :上一次开始执行时间点自后3秒再执行
	 * @Scheduled(fixedDelay=3000) :上一次执行完毕时间点之后3秒再执行
	 * @Scheduled(initialDelay=1000,fixedRate=3000) :第一次延迟1秒执行,之后按上一次开始执行时间点自后3秒再执行
	 */
	//@Scheduled(cron="*/1 * * * * *") linux crontab表达式定义规则
	public void showCurrentTime() {
		System.out.println("时间为:"+DATE_FORMAT.format(new Date()));
		repositoryService.CreateStar("定时");
	}
	
}
