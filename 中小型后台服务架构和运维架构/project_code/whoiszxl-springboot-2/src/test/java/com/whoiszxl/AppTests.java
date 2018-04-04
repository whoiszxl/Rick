package com.whoiszxl;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.whoiszxl.bean.secondary.Star;
import com.whoiszxl.repo.secondary.StarRepository;
import com.whoiszxl.service.StarService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class AppTests {

	@Autowired
	private StarRepository starRepository;
	
	@Autowired
	private StarService starService;
	
	@Test
	public void contextLoads() {
		List<Star> a1 = starRepository.findByStarname("定时");
		System.out.println("第一次查询:"+a1);
		List<Star> a2 = starRepository.findByStarname("定时");
		System.out.println("第二次查询:"+a2);
	}
	
	@Test
	public void ehCacheTest() {
		List<Star> all1 = starService.findAll();
		System.out.println("第一次查询:"+all1);
		List<Star> all2 = starService.findAll();
		System.out.println("第二次查询:"+all2);
	}
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Test
	public void testEmail() throws Exception {
		//发送一个简单的邮件
//		SimpleMailMessage message=new SimpleMailMessage();
//		message.setFrom("619563988@qq.com");
//		message.setTo("zxlme@foxmail.com");
//		message.setSubject("主题：测试邮件发送，简单发送");
//		message.setText("测试邮件简单发送的内容");
//		javaMailSender.send(message);
		
		//发送一个带有附件的邮件
//		MimeMessage message=javaMailSender.createMimeMessage();
//		
//		MimeMessageHelper helper=new MimeMessageHelper(message,true);
//		helper.setFrom("619563988@qq.com");
//		helper.setTo("zxlme@foxmail.com");
//		helper.setSubject("主题：测试邮件发送，带有附件的发送");
//		//helper.setText("测试邮件简单发送的内容，带有附件");
//		helper.setText("<html><body><img src=\"cid:tupian\"></body></html>",true);
//		
//		FileSystemResource file=new FileSystemResource(new File("I:\\findnothingdouble.jpg"));
//		//helper.addAttachment("图片.jpg", file);
//		helper.addInline("tupian", file);
//		javaMailSender.send(message);
		
		
		//发送模板邮件
		MimeMessage message=javaMailSender.createMimeMessage();		
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setFrom("619563988@qq.com");
		helper.setTo("zxlme@foxmail.com");
		helper.setSubject("主题：测试邮件发送，发送模板邮件");
        Map<String,Object> model=new HashedMap();
        model.put("username", "whoiszxl");
        String text=VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template.vm", model);
		helper.setText(text,true);
		
		
		javaMailSender.send(message);
	}

}
