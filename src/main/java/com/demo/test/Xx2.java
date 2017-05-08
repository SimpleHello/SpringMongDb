package com.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Xx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = getList();
		List<String> list2 = getList2();
		Map<String, List<String>> value = getCheckAlarm(list2,list);
//		for(Entry<String,List<String>> m: value.entrySet()){ 
//		    System.out.println(m.getKey()+"---"+m.getValue()); 
//		 } 
		System.out.println(value);
	}
	private static List<String> getList2(){
		List<String> list = new ArrayList<String>();
//		list.add("110102");
//		list.add("110228");
//		list.add("120102");
//		list.add("120103");
		list.add("330104");
		list.add("330105");
		list.add("330624");
		return list;
	}
	private static List<String> getList(){
		List<String> list = new ArrayList<String>();
		list.add("110102");
		list.add("110228");
		list.add("120102");
		list.add("120103");
		list.add("330104");
		list.add("330624");
		return list;
	}
	private static Map<String, List<String>> getCheckAlarm(List<String> queryList,List<String> tierlist) {
		Map<String, List<String>> returnMap = new HashMap<String, List<String>>();
		if(queryList==null||queryList.size()==0||tierlist==null||tierlist.size()==0){
			returnMap.put("4", null);
			return returnMap;
		}
		Map<String, Map<String, List<String>>> map = new HashMap<String, Map<String, List<String>>>();
		Map<String, List<String>> secondMap = null;
		List<String> queryTwoList =new ArrayList<String>();
		List<String> queryForeList =new ArrayList<String>();
		for (String str : queryList) {
			String first = str.substring(0, 2);
			String second = str.substring(2, 4);
			String third = str.substring(4, 6);
			if(!queryTwoList.contains(first)){
				queryTwoList.add(first);
			}
			if(!queryForeList.contains(first+second)){
				queryForeList.add(first+second);
			}
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
		int level = 1;
		for (String str : tierlist) {
			String first = str.substring(0, 2);
			String second = str.substring(2, 4);
			String third = str.substring(4, 6);
			if(map.containsKey(first)){
				Map<String, List<String>> co = map.get(first);
				if(!co.containsKey(second)){
					level = 3<level?level:3;
				}else {
					List<String> lo = co.get(second);
					if(!lo.contains(third)){
						level = 4;
						break;
					}
				} 
			}else{
				level = 2<level?level:2;
			}
		}
		/**
		 * 统计 level
		 * 1：全局 全选=>	三级分布的全国  				=>统计省级
		 * 2：第一级节点=>  三级分布的 省级 查询 xx/0000	=>统计市级
		 * 3：第二级节点=>  三级分布的 市级 查询 xxxx/00	=>统计区级
		 * 4：第三级节点=>  三级分布的 区级 查询 xxxxxx 	=>统计站点
		 */
		String value = String.valueOf(level);
		switch(value){
			case "1":returnMap.put(value, new ArrayList<String>() );break;
			case "2":returnMap.put(value, queryTwoList );break;
			case "3":returnMap.put(value, queryForeList );break;
			case "4":returnMap.put(value, null );break;
			default:returnMap.put(value, null );break;
		}
		return returnMap;
	}
}
