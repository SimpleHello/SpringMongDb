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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.entity.DemoEntity;
import com.mongodb.BasicDBObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:conf/applicationContext.xml")
public class MongdbTest {

	@Autowired
	MongoTemplate mongoTemplate;
	
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
		Criteria criteria = Criteria.where("age").gt(20);
		Query query = new Query();
		query.addCriteria(criteria);
		List<DemoEntity> demoList = mongoTemplate.find(query, DemoEntity.class, "dns");
		for(DemoEntity en:demoList){
			en.toStringCo();
		}
	}
	
	
	@Test
	public void insert() throws ParseException{
		List<DemoEntity> demoList = new ArrayList<DemoEntity>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] names = {"zhangsan","lisi","wangwu"};
		int[] ages = {21,18,25};
		String[] classNames = {"1class","2class","3class"};
		for(int j=0;j<3;j++){
			String name = names[j];
			int age = ages[j];
			String className = classNames[j];
			for(int i=1;i<10;i++){
				String date = "2017-0"+i+"-01";
				Date ctime = sdf.parse(date);
				int score = getRandom(40,100);
				DemoEntity entity = new DemoEntity();
				entity.setAge(age);
				entity.setName(name);
				entity.setClassName(className);
				entity.setScore(score);
				entity.setCtime(ctime);
				mongoTemplate.save(entity,"student");
			}	
		}
		
		
	}
	
	@Test
	public void groupMes(){
	    AggregationResults<BasicDBObject> result = mongoTemplate.aggregate(
                Aggregation.newAggregation(DemoEntity.class, 
                			match(Criteria.where("score").lt(60)), 
                			group("name","ctime").first("name").as("name1").first("ctime").as("niuctime").count().as("count") ,
                			sort(Sort.Direction.DESC, "name","ctime","count")),
                "student", 
                BasicDBObject.class);
	    List<BasicDBObject> list = result.getMappedResults();
	    for (int i = 0; i < list.size(); i++) {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	BasicDBObject object = list.get(i);
            System.out.println(" name:"+ object.getString("name1")+" ctime:"+sdf.format(object.getDate("niuctime"))+" count:"+object.getInt("count"));
        }
	}
	


	private int getRandom(int min,int max){
		return (int)(min+Math.random()*(max-min+1));
	}
}
