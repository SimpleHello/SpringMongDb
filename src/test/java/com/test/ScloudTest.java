package com.test;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.bind;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.entity.Alarm;
import com.demo.entity.AlarmQuery;
import com.demo.entity.test.Product;
import com.demo.entity.test.ZipInfo;
import com.demo.entity.test.ZipInfoStats;
import com.mongodb.BasicDBObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class ScloudTest {
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
	public void getAlarm() {
		Query querySloud = createQuery();
		List<Alarm> list = mongoTemplate.find(querySloud, Alarm.class, "yytdbattery_alarm");

		showMessage(list);
	}

	@Test
	public void getAlarmGroup() {
		try {
			TypedAggregation<Alarm> agg = Aggregation.newAggregation(Alarm.class,
					project("siteTier", "state", "shield"), unwind("siteTier"), match(getCriteria()),
					group("siteTier.name").first("siteTier.name").as("name").count().as("count"));
			AggregationResults<BasicDBObject> result = mongoTemplate.aggregate(agg, "yytdbattery_alarm",
					BasicDBObject.class);
			List<BasicDBObject> list = result.getMappedResults();
			System.out.println("-----------------------------");
			for (int i = 0; i < list.size(); i++) {
				BasicDBObject object = list.get(i);
				System.out.println(object);
			}
			System.out.println("-----------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getAlarmGroup1() {
		try {
			TypedAggregation<ZipInfo> aggregation = newAggregation(ZipInfo.class,
					group("state", "city").sum("population").as("pop"),
					sort(Sort.Direction.ASC, "pop", "state", "city"),
					group("state").last("city").as("biggestCity").last("pop").as("biggestPop").first("city")
							.as("smallestCity").first("pop").as("smallestPop"),
					project().and("state").previousOperation().and("biggestCity")
							.nested(bind("name", "biggestCity").and("population", "biggestPop")).and("smallestCity")
							.nested(bind("name", "smallestCity").and("population", "smallestPop")),
					sort(Sort.Direction.ASC, "state"));

			AggregationResults<ZipInfoStats> result = mongoTemplate.aggregate(aggregation,"student07", ZipInfoStats.class);
			ZipInfoStats firstZipInfoStats = result.getMappedResults().get(0);
			ZipInfoStats firstZipInfoStats1 = result.getMappedResults().get(1);
			System.out.println("-----------------------------");
			String str = firstZipInfoStats.toString();
			String str1 = firstZipInfoStats1.toString();
			System.out.println(str);
			System.out.println(str1);
			System.out.println("-----------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getAlarmGroup2() {
		List<String> li = new ArrayList<String>();
		li.add("11");
		li.add("33");
		Criteria criteria = Criteria.where("state").is("待处理").and("first").in(li);
		try{
			TypedAggregation<Alarm> agg = newAggregation(Alarm.class,
					project("level","signal","device","site","siteTier","tierCode","state")
					   .andExpression("substr(tierCode,0,2)").as("first")
					   .andExpression("substr(tierCode,0,4)").as("second"),
					match(criteria),
					limit(10)

			);
			AggregationResults<BasicDBObject> result = mongoTemplate.aggregate(agg, "yytdbattery_alarm", BasicDBObject.class);
			List<BasicDBObject> list = result.getMappedResults();
			System.out.println("-----------------------------");
			for (int i = 0; i < list.size(); i++) {
				BasicDBObject object = list.get(i);
				System.out.println(object);
			}
			System.out.println("-----------------------------");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	@Test
	public void getAlarmGroup3() {
		TypedAggregation<Product> agg = newAggregation(Product.class,
				project("name", "netPrice").andExpression("netPrice + 1").as("netPricePlus1")
						.andExpression("netPrice - 1").as("netPriceMinus1").andExpression("netPrice / 2")
						.as("netPriceDiv2").andExpression("netPrice * 1.19").as("grossPrice")
						.andExpression("spaceUnits % 2").as("spaceUnitsMod2")
						.andExpression("(netPrice * 0.8  + 1.2) * 1.19").as("grossPriceIncludingDiscountAndCharge")

		);

		AggregationResults<BasicDBObject> result = mongoTemplate.aggregate(agg, "student05", BasicDBObject.class);
		List<BasicDBObject> list = result.getMappedResults();
		System.out.println("-----------------------------");
		for (int i = 0; i < list.size(); i++) {
			BasicDBObject object = list.get(i);
			System.out.println(object);
		}
		System.out.println("-----------------------------");
	}

	private void showMessage(List<Alarm> list) {
		System.out.println("-----------------------------");
		if (list == null) {
			System.out.println("list 无数据!");
		} else {
			for (Alarm alarm : list) {
				String str = alarm.toString();
				System.out.println(str);
			}
		}
		System.out.println("-----------------------------");
	}

	private Criteria getCriteria() {
		AlarmQuery query = new AlarmQuery();
		// query.setAlarmLevel("2");
		// query.setAlarmName("过低");
		query.setPage(1);
		query.setAlarmState("待处理");
		// query.setDeviceName("240");
		Criteria ca = createForBase(query);
		return ca;
	}

	private Query createQuery() {
		Criteria ca = getCriteria();
		Query querySloud = new Query(ca);
		// 根据告警时间降序排列
		// querySloud.with(new Sort(Sort.Direction.DESC, "tReport"));
		querySloud.skip(0).limit(15);
		return querySloud;
	}

	/**
	 * 创建标准查询告警的查询条件
	 *
	 * @param query
	 * @return
	 */
	private Criteria createForBase(AlarmQuery query) {
		List siteIds = query.getSiteIds();
		String alarmName = query.getAlarmName();
		String level = query.getAlarmLevel();
		String device = query.getDeviceName();
		String state = query.getAlarmState();
		Date tStart = (query.gettStart() == null) ? null : new Date(query.gettStart());
		Date tEnd = (query.gettEnd() == null) ? new Date() : new Date(query.gettEnd());

		Criteria criteria = Criteria.where("shield").ne(false);
		if (siteIds != null && !siteIds.isEmpty()) {
			criteria.and("site.strId").in(siteIds);
		}
		if (tStart != null) {
			criteria.and("tReport").gte(tStart).lte(tEnd);
		}
		if (state != null) {
			criteria.and("state").is(state);
		}
		if (device != null) {
			criteria.and("device.name").regex(".*?" + device + ".*?");
		}
		if (alarmName != null) {
			criteria.and("signal.name").regex(".*?" + alarmName + ".*?");
		}
		if (level != null) {
			criteria.and("level").is(level);
		}
		return criteria;
	}
}
