package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.demo.entity.DemoEntity;

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

	public void insert(DemoEntity entity) {
		mongoTemplate.save(entity, "newdemo");
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

}
