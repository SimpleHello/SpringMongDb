package com.auth;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.entity.Role;
import com.demo.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class AuthTest {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Before
	public void bef() {
		System.out.println("开始单元测试");
	}

	@After
	public void aft() {
		System.out.println("测试结束");
	}
	/**
	 * 新增 用户
	 */
	@Test
	public void rtspToRtmp() {
		try {
			User user1 = new User(); 
			user1.setUserame("admin");
			user1.setPassword("123456");
			mongoTemplate.save(user1, "user");
			user1.setUserame("zhangsan");
			user1.setPassword("123456");
			mongoTemplate.save(user1, "user");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
