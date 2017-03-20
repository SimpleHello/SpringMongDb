package com.demo.entity;

import com.demo.common.IEntity;

public class DemoEntity extends IEntity{
	private String id;
	private String name;
	private int age;
	private String className;
	private String tian;
	private String type;
	public DemoEntity(){
		
	}
	public DemoEntity(String name,int age,String className,String tian){
		this.name = name;
		this.age = age;
		this.className=className;
		this.tian = tian;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTian() {
		return tian;
	}
	public void setTian(String tian) {
		this.tian = tian;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
