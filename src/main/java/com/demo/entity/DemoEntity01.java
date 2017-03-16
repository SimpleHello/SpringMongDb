package com.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DemoEntity01 {
	private String id;
	private String[] ids;
	private Date nowDate;
	private Integer[] ages;
	private DemoEntity entity;
	private Map<String,String> map;
	private List<DemoEntity> list;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Date getNowDate() {
		return nowDate;
	}
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	public Integer[] getAges() {
		return ages;
	}
	public void setAges(Integer[] ages) {
		this.ages = ages;
	}
	public DemoEntity getEntity() {
		return entity;
	}
	public void setEntity(DemoEntity entity) {
		this.entity = entity;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public List<DemoEntity> getList() {
		return list;
	}
	public void setList(List<DemoEntity> list) {
		this.list = list;
	}
	
	
}
