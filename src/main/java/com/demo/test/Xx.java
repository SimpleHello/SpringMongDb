package com.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = getList();
		List<String> list2 = getList2();
		String value = getCheckAlarm(list2,list);
		System.out.println(value);
	}
	private static List<String> getList2(){
		List<String> list = new ArrayList<String>();
//		list.add("110101");
//		list.add("110102");
//		list.add("110103");
//		list.add("110201");
//		list.add("110202");
		list.add("120101");
//		list.add("120102");
//		list.add("120201");
//		list.add("120202");
//		list.add("130101");
		return list;
	}
	private static List<String> getList(){
		List<String> list = new ArrayList<String>();
		list.add("110101");
		list.add("110102");
		list.add("110103");
		list.add("110201");
		list.add("110202");
		list.add("120101");
		list.add("120102");
		list.add("120201");
		list.add("120202");
		list.add("130101");
		return list;
	}
	
	private static String getCheckAlarm(List<String> six,List<String> list) {
		Map<String, Map<String, List<String>>> map = new HashMap<String, Map<String, List<String>>>();
		Map<String, List<String>> secondMap = null;
		for (String str : six) {
			String first = str.substring(0, 2);
			String second = str.substring(2, 4);
			String third = str.substring(4, 6);
			if (map.containsKey(first)) {
				secondMap = map.get(first);
			} else {
				secondMap = new HashMap<String, List<String>>();
			}
			if (secondMap.containsKey(second)) {
				List<String> th = secondMap.get(second);
				if(!th.contains(third)){
					th.add(third);
				}
				secondMap.put(second, th);
			} else {
				List<String> thirdlist = new ArrayList<String>();
				thirdlist.add(third);
				secondMap.put(second, thirdlist);
			}
			map.put(first, secondMap);	
		}
		//{12={01=[01, 02], 02=[01]}}
		int strr = 1;
		for (String str : list) {
			String first = str.substring(0, 2);
			String second = str.substring(2, 4);
			String third = str.substring(4, 6);
			if(map.containsKey(first)){
				Map<String, List<String>> co = map.get(first);
				if(!co.containsKey(second)){
					strr = 3;
				}else {
					List<String> lo = co.get(second);
					if(!lo.contains(third)){
						return String.valueOf(4);
					}else{
						lo.remove(third);
					}
				} 
			}else{
				strr = 2<strr?strr:2;
			}
		}
		return String.valueOf(strr);
	}
}
