package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.JsonResult;

@Controller
@RequestMapping(value = "/ajax", method = RequestMethod.POST)
public class AjaxDemo {
	
	private String resultName;
	
	@RequestMapping(value = "/getSomeAjax/{name}", method = RequestMethod.POST)
	public @ResponseBody JsonResult getSomeAjax(@PathVariable String name,HttpServletRequest request) {
		try {
			System.out.println("接收到参数:"+name);
			resultName = new String();
			resultName = name;
			Map<String,Object> map = new HashMap<String,Object>();
			
			if(resultName!=null&&resultName.equals("zhangsan")){
				Thread.sleep(10000);//模拟 查询时间 10秒
			}
			map.put("name", resultName);
			System.out.println("最后结果：传值："+name+" 返回值:"+resultName);
			return new JsonResult(map);
		} catch (Exception e) {
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
}
