package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.JsonResult;
import com.demo.entity.DemoEntity;
import com.demo.service.DemoService;

@Controller
@RequestMapping(value = "/simpleDemo", method = RequestMethod.POST)
public class DemoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping(value = "/getDemoMess", method = RequestMethod.POST)
	public @ResponseBody JsonResult getAlarmCount(HttpServletRequest request) {
		System.out.println("进入了次方法");
		try {
			List<String> demoList = new ArrayList<String>();
			for (int i = 0; i < 4; i++) {
				demoList.add("测试demo" + i);
			}
			return new JsonResult(demoList);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/getDemoMongDb", method = RequestMethod.POST)
	public @ResponseBody JsonResult getDemoMongDb(@RequestBody DemoEntity entity,HttpServletRequest request) {
		System.out.println("进入了 此 getDemoMongDb 方法");
		try {
			List<DemoEntity> demoList =demoService.find(entity);
			return new JsonResult(demoList);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
}
