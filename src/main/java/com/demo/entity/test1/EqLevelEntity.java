package com.demo.entity.test1;

import java.util.List;

public class EqLevelEntity {
	
	private String level;
	private String color;
	private List<String> assort;
	public EqLevelEntity(){
		
	}
	public EqLevelEntity(String level, String color, List<String> assort) {
		super();
		this.level = level;
		this.color = color;
		this.assort = assort;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<String> getAssort() {
		return assort;
	}
	public void setAssort(List<String> assort) {
		this.assort = assort;
	}
	
	
	
}
