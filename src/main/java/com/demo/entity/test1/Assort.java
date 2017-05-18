package com.demo.entity.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assort {
	
	public static List<String> getlistDetail(){
		List<String> list = new ArrayList<String>();
		for(int i =1;i<10;i++){
			list.add("star-"+i); //9
		}
		for(int i =1;i<6;i++){
			list.add("moon-"+i);//10-15
		}
		for(int i =1;i<4;i++){
			list.add("sun-"+i);//16-18
		}
		list.add("Diamond");//19
		list.add("s");//20
		list.add("ss");//21
		list.add("sss");//22
		return list;
	}
	public static List<String> getlistLocat(){
		String str = "house,community,village,town,city,province,country,earth,solar,Milky,universe";
		return getList(str);
	}
	public static List<String> getlistColor(){
		String str = "grey,Maroon,black,green,blue,yellow,gold,purple,pink,red,rainbow";
		return getList(str);
	}
	/**
	 * house,community,village,town,city,province,country,earth,solar,Milky,universe
	   grey,Maroon,black,green,blue,yellow,gold,purple,pink,red,rainbow
	 * @param str
	 * @return
	 */
	public static List<String> getList(String str){
		return Arrays.asList(str.split(","));
	}
	
}
