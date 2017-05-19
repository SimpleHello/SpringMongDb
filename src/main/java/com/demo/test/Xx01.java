package com.demo.test;

import java.util.ArrayList;
import java.util.List;

import com.demo.entity.test1.Assort;

public class Xx01 {
	public static void main(String[] args){
		List<String> list = Assort.getlistDetail(14);
		showList(list);
	}

	
	public static void showList(List<String> list){
		for(String str:list){
			System.out.println(str);
		}
	}
}
