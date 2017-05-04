package com.demo.entity.test;

public class ZipInfoStats {
	private String id;
	private String state;
	private City biggestCity;
	private City smallestCity;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public City getBiggestCity() {
		return biggestCity;
	}
	public void setBiggestCity(City biggestCity) {
		this.biggestCity = biggestCity;
	}
	public City getSmallestCity() {
		return smallestCity;
	}
	public void setSmallestCity(City smallestCity) {
		this.smallestCity = smallestCity;
	}
	@Override
	public String toString() {
		return "ZipInfoStats [id=" + id + ", state=" + state + ", biggestCity=" + biggestCity + ", smallestCity="
				+ smallestCity + "]";
	}
	
	
}
