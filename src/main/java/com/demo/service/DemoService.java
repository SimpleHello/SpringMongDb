package com.demo.service;

import java.util.List;

import com.demo.entity.DemoEntity;
import com.demo.entity.DemoEntity01;

public interface DemoService {
	
	List<DemoEntity> find(DemoEntity entity);
	
	List<DemoEntity01> findMore(DemoEntity01 entity);
	void insert(DemoEntity entity);
	
	void insertMore();
	
	void update(DemoEntity entity);
	
	void delete(DemoEntity entity);
}
