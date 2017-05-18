package com.test;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.entity.DemoEntity;
import com.demo.entity.Tier;
import com.mongodb.BasicDBObject;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
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
	public void cs() {
		try {
			Criteria criteria = Criteria.where("age").gt(20);
			Query query = new Query();
			query.addCriteria(criteria);
			DemoEntity demoList = mongoTemplate.findOne(query, DemoEntity.class, "student111");
			System.out.println("d");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void css() {
		try {
			TypedAggregation<Tier> agg = Aggregation.newAggregation(
					Tier.class, 
					project("tierCode", "tierNames", "latitude","longitude")
					   .andExpression("substr(tierCode,0,2)").as("first")
					   .andExpression("substr(tierCode,0,4)").as("second"));
			AggregationResults<Tier> result = mongoTemplate.aggregate(agg, "yytdbattery_tier_copy",Tier.class);
			List<Tier> list = result.getMappedResults();
			System.out.println("-----------------------------");
			for (int i = 0; i < list.size(); i++) {
				Tier object = list.get(i);
				System.out.println(object.toString());
			}
			System.out.println("-----------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
