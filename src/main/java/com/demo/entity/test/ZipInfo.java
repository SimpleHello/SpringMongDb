package com.demo.entity.test;

public class ZipInfo {
	private String id;
	private String city;
	private String state;
	private int pop;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPop() {
		return pop;
	}
	public void setPop(int pop) {
		this.pop = pop;
	}
	@Override
	public String toString() {
		return "ZipInfo [id=" + id + ", city=" + city + ", state=" + state + ", pop=" + pop + "]";
	}

	
	
}
