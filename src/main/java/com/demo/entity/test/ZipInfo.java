package com.demo.entity.test;

import org.springframework.data.mongodb.core.mapping.Field;

public class ZipInfo {
	private String id;
	private String city;
	private String state;
	@Field("pop")
	private int population;
	@Field("loc")
	private double[] location;
	
	
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
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public double[] getLocation() {
		return location;
	}
	public void setLocation(double[] location) {
		this.location = location;
	}
	
	
}
