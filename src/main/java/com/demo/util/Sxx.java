package com.demo.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import com.demo.common.FacadeView;
import com.demo.entity.Alarm;

public class Sxx {
	public static void main(String[] args){
		Alarm al = new Alarm();
		FacadeView signal = new FacadeView("ss","ssss");
		al.settReport(new Date());
		al.setSignal(signal);
		Object obj = getFieldValue(al,"signal");
		Object objx = getFieldValue(al,"device");
		Object objw = getFieldValue(al,"signal");
		Object objj = getFieldValue(obj,"name");
		System.out.println(objj);
	}
	
	public  static Object getFieldValue(Object o, String fields) {
		try {
			Class<?> clazz = o.getClass();
			Field field1 = clazz.getDeclaredField(fields);
			Method getMethod = null;
			PropertyDescriptor pd = null;
			if(isAcronym(fields)){
				 getMethod = clazz.getMethod("get"+fields);	 
			}else{
				 pd = new PropertyDescriptor(field1.getName(), clazz);
				 getMethod = pd.getReadMethod();
			}
			if (getMethod.invoke(o) != null) {
				Object ret = getMethod.invoke(o);
				if (ret instanceof FacadeView) {
					return DateUtil.getInstance().format((Date) ret, "yyyy-MM-dd HH:mm:ss");
				}
				return ret;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;//对 该类未含有该属性值时 产生的 异常 返回 null
		}
	}
	public static boolean isAcronym(String word) {
		char first = word.charAt(0);
		char second= word.charAt(1);
		if (Character.isLowerCase(first)&&(Character.isUpperCase(second))) {
			return true;
		}
		return false;
	}
}
