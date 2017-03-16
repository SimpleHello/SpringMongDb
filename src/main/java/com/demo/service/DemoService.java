package com.demo.service;

import java.util.List;

import com.demo.entity.DemoEntity;

public interface DemoService {
	
	List<DemoEntity> find(DemoEntity entity);
	
	void insert(DemoEntity entity);
	
	void update(DemoEntity entity);
	
	void delete(DemoEntity entity);
}
