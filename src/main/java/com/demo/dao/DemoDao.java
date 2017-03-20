package com.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.demo.entity.DemoEntity;
import com.demo.entity.DemoEntity01;
import com.mongodb.BasicDBObject;

@Repository
public class DemoDao {
	@Autowired
	MongoTemplate mongoTemplate;

	public List<DemoEntity> find(DemoEntity entity) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("age").gt(entity.getAge());
		Query query = new Query();
		query.addCriteria(criteria);
		return mongoTemplate.find(query, DemoEntity.class, "dns");
	}

	public List<DemoEntity01> findMore(DemoEntity01 entity) {
		// TODO Auto-generated method stub
		int age = 0;
		if(entity!=null&&entity.getEntity()!=null){
			age =  entity.getEntity().getAge();
		}
		Criteria criteria = Criteria.where("entity.age").gt(age);
		Query query = new Query();
		query.addCriteria(criteria);
		return mongoTemplate.find(query, DemoEntity01.class, "newdemo_091");
	}
	
	public void insert(DemoEntity entity) {
		mongoTemplate.save(entity, "newdemo");
	}

	
	public void insertMore() {
		DemoEntity01 entity01 = new DemoEntity01();
		Integer[] ages = {10,22};
		String[] ids={"123n13nk123nm","213sdsfdsdfc"};
		List<DemoEntity> list = new ArrayList<DemoEntity>();
		Map<String,String> map = new HashMap<String,String>();
		DemoEntity en1 = new DemoEntity("ron1",29,"6班","java");
		DemoEntity en2 = new DemoEntity("tom",28,"6班","c++");
		DemoEntity en3 = new DemoEntity("ron1",29,"7班","windows");
		DemoEntity en4 = new DemoEntity("ron1",29,"8班","Linux");
		list.add(en1);
		list.add(en2);
		list.add(en3);
		list.add(en4);
		en1.setAge(20);
		entity01.setAges(ages);
		entity01.setIds(ids);
		entity01.setEntity(en3);
		entity01.setList(list);
		entity01.setNowDate(new Date());
		map.put("001", "023ass");
		map.put("002", "023ass");
		map.put("003", "0113ass");
		map.put("004", "dsass");
		entity01.setMap(map);
		mongoTemplate.save(entity01, "newdemo_091");
	}
	
	public void update(DemoEntity entity) {
		Update update = new Update();
		update.set("name", entity.getName());
		Query query = new Query();
		Criteria cat = Criteria.where("_id").is(entity.getId());
		query.addCriteria(cat);
		mongoTemplate.updateFirst(query,update,DemoEntity.class,"newdemo");
	}

	public void delete(DemoEntity entity) {
		mongoTemplate.remove(
				new Query(Criteria.where("_id").is(entity.getId())), 
				DemoEntity.class, "newdemo");
	}
	 /**
     *
     * @param uniqueCode
     * @param siteId
     * @return
     */
    public List<Map<String, Object>> findGroupQuery() {
        AggregationResults<BasicDBObject> result = mongoTemplate.aggregate(
                Aggregation.newAggregation(
                		DemoEntity.class,
                        Aggregation.match(Criteria.where("name").exists(true)
                                .and("type").exists(true)),
                        Aggregation.group("name", "type")),
                "fruit2",
                BasicDBObject.class);

        List<BasicDBObject> list = result.getMappedResults();
        List<Map<String, Object>> queryList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            BasicDBObject object = list.get(i);
            Map<String, Object> map = new HashMap<>();
            map.put("name", object.getString("name"));
            map.put("type", object.getString("type"));
            queryList.add(map);
        }
        return queryList;
    }
}
