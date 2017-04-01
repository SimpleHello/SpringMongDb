package com.demo.entity;

public class Student {
	private String name = "lisiss";
	private int age;
	private String classs;
	private String classBefore;
	private String str1;
	private String str2;
	
	public Student(){
		
	}
	public Student(String name, int age, String classs, String str1, String str2) {
		this.name = name;
		this.age = age;
		this.classs = classs;
		this.classBefore= classs;
		this.str1 = str1;
		this.str2 = str2;
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
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public String getStr1() {
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	public String getStr2() {
		return str2;
	}
	public void setStr2(String str2) {
		this.str2 = str2;
	}
	public String getClassBefore() {
		return classBefore;
	}
	public void setClassBefore(String classBefore) {
		this.classBefore = classBefore;
	}
	
	
}
