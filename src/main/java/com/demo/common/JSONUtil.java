/**
 * *****************************************************
 * Copyright (C) Kongtrolink techology Co.ltd - All Rights Reserved
 *
 * This file is part of Kongtrolink techology Co.Ltd property.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************
 */
package com.demo.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.types.ObjectId;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Mosaico
 */
public class JSONUtil {
    
    /**
     * 将对象解析为JSON文档，对象中的ObjectId自动解析为toString()得到的字符串。
     * @param object
     * @return 
     */
    public static String toJsonString(Object object) {
	Class clazz = object.getClass();
	Field[] fields = clazz.getDeclaredFields();
	List<Field> fieldList = Arrays.asList(fields);
	Collections.sort(fieldList, new Comparator<Field>() {

	    @Override
	    public int compare(Field o1, Field o2) {
		String name1 = o1.getName();
		String name2 = o2.getName();
		// 去除属性名前面的"_"
		while (name1.startsWith("_")) {
		    name1 = name1.substring(1, name1.length());
		}
		while (name2.startsWith("_")) {
		    name2 = name2.substring(1, name2.length());
		}
		
		return name1.compareTo(name2);
	    }
	    
	});
	
	try {
	    String builder = "";
	    for (Field field : fieldList) {
		field.setAccessible(true);
		if (field.get(object) == null) {
		    continue;
		}
		
		String key = field.getName();
		while (key.startsWith("_")) {
		    key = key.substring(1, key.length());
		}
		
		String value;
		if (field.getType().equals(ObjectId.class)) {
		    value = "\"" + field.get(object).toString() + "\"";
		} else if (field.getType().equals(FacadeView.class)) {
		    value = JSONUtil.toJsonString(field.get(object));
		} else if (field.getType().getName().contains("List")) {
		    value = JSONUtil.toListJsonString((List)field.get(object));
		} else  {
		    value = JSONObject.toJSONString(field.get(object));
		}
		builder += "\"" + key + "\":" + value + ",";
	    }
	    if (!builder.isEmpty()) {
		builder = builder.substring(0, builder.length() - 1);
	    }
	    return "{" + builder + "}";
	} catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
	    Logger.getLogger(JSONUtil.class.getName()).log(Level.SEVERE, null, ex);
	}
	return "";
    }
    
    /**
     * 将List对象解析成JSON文档
     * @param list
     * @return 
     */
    public static String toListJsonString(List list) {
	String builder = "";
	for (Object object : list) {
	    builder += JSONUtil.toJsonString(object);
	    builder += ",";
	}
	if (!builder.isEmpty()) {
	    builder = builder.substring(0, builder.length() - 1);
	}
	return "[" + builder + "]";
    }
    
}
