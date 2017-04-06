package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.activiiMQ.MessageSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:conf/applicationContext.xml")
public class ActiveMQTest {
	
	@Autowired
	MessageSender messageSender;
	
	@Before
	public void bef(){
		System.out.println("开始单元测试");
	}
	
	@After
	public void aft(){
		System.out.println("测试结束");
	}
	
	@Test
	public void checkInit(){
//		messageSender.sendMessage("this is just a test");
	}
	
	
}
