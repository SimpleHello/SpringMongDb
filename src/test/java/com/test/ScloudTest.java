package com.test;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.text.SimpleDateFormat;
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

import com.demo.entity.Alarm;
import com.demo.entity.AlarmQuery;
import com.demo.entity.DemoEntity;
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
		AggregationResults<BasicDBObject> result = mongoTemplate.aggregate(
				Aggregation.newAggregation(Alarm.class, match(getCriteria()),
						group("site.name").first("site.name").as("name").count().as("count"),
						sort(Sort.Direction.DESC, "count")),
				"yytdbattery_alarm", BasicDBObject.class);
		List<BasicDBObject> list = result.getMappedResults();
		System.out.println("-----------------------------");
		for (int i = 0; i < list.size(); i++) {
			BasicDBObject object = list.get(i);
			System.out.println(" name:" + object.getString("name")
					+ " count:" + object.getInt("count"));
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

	private Criteria getCriteria(){
		AlarmQuery query = new AlarmQuery();
		query.setAlarmLevel("2");
//		query.setAlarmName("过低");
		query.setPage(1);
		query.setAlarmState("待处理");
//		query.setDeviceName("240");
		Criteria ca = createForBase(query);
		return ca;
	}
	
	private Query createQuery() {
		Criteria ca = getCriteria();
		Query querySloud = new Query(ca);
		// 根据告警时间降序排列
		querySloud.with(new Sort(Sort.Direction.DESC, "tReport"));
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

		Criteria criteria = Criteria.where("shield").ne(true);
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
