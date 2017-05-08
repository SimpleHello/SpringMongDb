package com.demo.test;

public class Xx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "0002";
		String first = key.substring(0, 2);
		String second = key.substring(2, 4);
		if("00".equals(first)){
			if("00".equals(second)){
				key = key.substring(4);
			}else{
				key = key.substring(2); 	
			}
		}
		System.out.println(key);
	}
	
}
