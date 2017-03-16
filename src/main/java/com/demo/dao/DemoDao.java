package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
		 return mongoTemplate.find(query, DemoEntity.class,"dns");
		}
}
