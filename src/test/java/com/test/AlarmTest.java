package com.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.entity.DemoEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:conf/applicationContext.xml")
public class AlarmTest {
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
	
	@Test
	public void cs(){
		try{
			Criteria criteria = Criteria.where("age").gt(20);
			Query query = new Query();
			query.addCriteria(criteria);
			DemoEntity demoList = mongoTemplate.findOne(query,DemoEntity.class, "student111");
			System.out.println("d");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
