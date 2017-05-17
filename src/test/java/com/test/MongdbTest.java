package com.test;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.entity.DemoEntity;
import com.demo.entity.JobEntity;
import com.demo.entity.JobRunningLogEntity;
import com.demo.entity.test.ZipInfo;
import com.mongodb.BasicDBObject;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class MongdbTest {

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
	public void checkInit() {
		try {
			int[] ages = {22};
			Criteria criteria = Criteria.where("age").in(ages);
			Criteria criteria2 = Criteria.where("age").in(ages);
			criteria.orOperator(criteria2);
			Query query = new Query(criteria);
			DemoEntity entity = mongoTemplate.findOne(query, DemoEntity.class,"student01");
			System.out.println("111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void checkInit222() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			List<JobRunningLogEntity> demoList = mongoTemplate.findAll(JobRunningLogEntity.class, "quartz_running_log");
			for (JobRunningLogEntity en : demoList) {
				System.out.println("jobName:" + en.getJobName());
				System.out.println("ctime:" + sdf.format(en.getCtime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insert() throws ParseException {
		List<DemoEntity> demoList = new ArrayList<DemoEntity>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] names = { "zhangsan", "lisi", "wangwu" };
		int[] ages = { 21, 18, 25 };
		String[] classNames = { "1class", "2class", "3class" };
		for (int j = 0; j < 3; j++) {
			String name = names[j];
			int age = ages[j];
			String className = classNames[j];
			for (int i = 1; i < 10; i++) {
				String date = "2017-0" + i + "-01";
				Date ctime = sdf.parse(date);
				int score = getRandom(40, 100);
				DemoEntity entity = new DemoEntity();
				entity.setAge(age);
				entity.setName(name);
				entity.setClassName(className);
				entity.setScore(score);
				entity.setCtime(new Date());
				mongoTemplate.save(entity, "student01");
			}
		}

	}

	@Test
	public void groupMes() {
		AggregationResults<BasicDBObject> result = mongoTemplate.aggregate(
				Aggregation.newAggregation(DemoEntity.class, match(Criteria.where("score").lt(60)),
						group("name", "ctime").first("name").as("name1").first("ctime").as("niuctime").count()
								.as("count"),
						sort(Sort.Direction.DESC, "name", "ctime", "count")),
				"student", BasicDBObject.class);
		List<BasicDBObject> list = result.getMappedResults();
		for (int i = 0; i < list.size(); i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			BasicDBObject object = list.get(i);
			System.out.println(" name:" + object.getString("name1") + " ctime:" + sdf.format(object.getDate("niuctime"))
					+ " count:" + object.getInt("count"));
		}
	}

	@Test
	public void groupMes2() {
		try {
			TypedAggregation<ZipInfo> agg =  Aggregation.newAggregation(ZipInfo.class,
					group("city","state").sum("pop").as("xxas"), 
					group("city","xxas").count().as("pop")
//					project("pop").and("city").previousOperation()
				);
			
			AggregationResults<ZipInfo> result = mongoTemplate.aggregate(agg,"student07", ZipInfo.class);
			List<ZipInfo> list = result.getMappedResults();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void find() {
		DemoEntity entity = mongoTemplate.findOne(new Query(Criteria.where("score").is(100)), DemoEntity.class,
				"student00");
		entity.toStringCo();
		update(entity);
	}

	@Test
	public void findAll() {
		List<JobEntity> findAll = mongoTemplate.findAll(JobEntity.class, JobEntity.namespace);
		for (JobEntity en : findAll) {
			System.out.println(en.getJobName());
		}
	}

	@Test
	public void updateAll() {
		Update update = new Update();
		update.set("score", "61");
		mongoTemplate.updateMulti(new Query(), update, "student00");
	}

	public void update(DemoEntity entity) {
		Update update = new Update();
		update.set("score", 30);
		update.set("name", "wudi");
		Query query = new Query();
		Criteria cat = Criteria.where("_id").is(entity.getId());
		query.addCriteria(cat);
		mongoTemplate.updateFirst(query, update, DemoEntity.class, "student00");
	}

	private int getRandom(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}
