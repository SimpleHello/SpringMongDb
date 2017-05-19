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
			list.add("moon-"+i);//10-14
		}
		for(int i =1;i<4;i++){
			list.add("sun-"+i);//15-17
		}
		list.add("s");//18
		list.add("ss");//19
		list.add("sss");//20
		return list;
	}
	public static List<String> getlistDetail(int y){
		return getlistDetail(1,y);
	}
	
	public static List<String> getlistDetail(int x,int y){
		List<String> list = new ArrayList<String>();
		List<String> listx = getlistDetail();
		if(y>listx.size()){
			return null;
		}
		for(int i =x;i<y+1;i++){
			list.add(listx.get(i-1)); //9
		}
		
		return list;
	}
	public static List<String> getlistLocat(){
		String str = "house,community,village,town,city,province,country,earth,solar,milky,universe";
		return getList(str);
	}
	public static List<String> getlistColor(){
		String str = "grey,maroon,black,green,blue,yellow,gold,purple,pink,red,rainbow";
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
