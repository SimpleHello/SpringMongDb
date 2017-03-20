package com.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.DemoDao;
import com.demo.dao.DemoDao2;
import com.demo.entity.DemoEntity;
import com.demo.entity.DemoEntity01;
import com.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	DemoDao demoDao;
	
	@Autowired
	DemoDao2 demoDao2;
	
	@Override
	public List<DemoEntity> find(DemoEntity entity) {
		// TODO Auto-generated method stub
		return demoDao.find(entity);
	}

	@Override
	public List<DemoEntity> find2(DemoEntity entity) {
		// TODO Auto-generated method stub
		return demoDao2.find(entity);
	}
	
	@Override
	public void insert(DemoEntity entity) {
		// TODO Auto-generated method stub
		demoDao.insert(entity);
	}

	@Override
	public void update(DemoEntity entity) {
		// TODO Auto-generated method stub
		demoDao.update(entity);
	}

	@Override
	public void delete(DemoEntity entity) {
		// TODO Auto-generated method stub
		demoDao.delete(entity);
	}

	@Override
	public void insertMore() {
		// TODO Auto-generated method stub
		demoDao.insertMore();
	}

	@Override
	public List<DemoEntity01> findMore(DemoEntity01 entity) {
		// TODO Auto-generated method stub
		return demoDao.findMore(entity);
	}

	@Override
	public List<Map<String, Object>> findGroupQuery() {
		// TODO Auto-generated method stub
		return demoDao.findGroupQuery();
	}

}
