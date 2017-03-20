package com.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.demo.common.BaseMongoDAOImpl;
import com.demo.entity.DemoEntity;

@Repository
public class DemoDao2 extends BaseMongoDAOImpl<DemoEntity>{

	public List<DemoEntity> find(DemoEntity entity) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("name").is(entity.getName());
		Query query = new Query();
		query.addCriteria(criteria);
		return find(query,"fruit2");
	}
}
