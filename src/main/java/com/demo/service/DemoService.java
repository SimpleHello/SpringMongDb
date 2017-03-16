package com.demo.service;

import java.util.List;

import com.demo.entity.DemoEntity;

public interface DemoService {
	
	List<DemoEntity> find(DemoEntity entity);
}
