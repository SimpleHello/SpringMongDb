package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.entity.User;

public class LoginDao {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public User getUser(String name){
		Criteria criteria = Criteria.where("username").in(name);
		Query query = new Query(criteria);
		return mongoTemplate.findOne(query, User.class, "user");
	}
	
	
}
