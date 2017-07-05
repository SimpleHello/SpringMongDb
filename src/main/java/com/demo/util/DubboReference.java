package com.demo.util;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.spring.ReferenceBean;

@Service
public class DubboReference {

	 @Autowired  
	 private ApplicationContext applicationContext;
	 
	public  Object Sxx(String id,Class<?> interfaceClass,String group){
		System.out.println("--------------------进入了此方法");
		Object obj = null;
		ReferenceBean<T> referenceBean = new ReferenceBean<T>();  
        referenceBean.setApplicationContext(applicationContext); 
        referenceBean.setId(id);
        referenceBean.setInterface(interfaceClass);   
        referenceBean.setGroup(group);
        try {  
            referenceBean.afterPropertiesSet();  
            obj = referenceBean.get();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return obj;
	}
}
