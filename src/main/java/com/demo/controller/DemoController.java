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
import com.demo.entity.DemoEntity01;
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
	
	@RequestMapping(value = "/getDemoMongDb2", method = RequestMethod.POST)
	public @ResponseBody JsonResult getDemoMongDb2(@RequestBody DemoEntity entity,HttpServletRequest request) {
		System.out.println("进入了 此 getDemoMongDb2 方法");
		try {
			List<DemoEntity> demoList =demoService.find2(entity);
			return new JsonResult(demoList);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/getMoreDemoMongDb", method = RequestMethod.POST)
	public @ResponseBody JsonResult getMoreDemoMongDb(@RequestBody DemoEntity01 entity,HttpServletRequest request) {
		System.out.println("进入了 此 getDemoMongDb 方法");
		try {
			List<DemoEntity01> demoList =demoService.findMore(entity);
			return new JsonResult(demoList);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/insertDemoMongDb", method = RequestMethod.POST)
	public @ResponseBody JsonResult insertDemoMongDb(@RequestBody DemoEntity entity,HttpServletRequest request) {
		System.out.println("进入了 此 insertDemoMongDb 方法");
		try {
			demoService.insert(entity);
			return new JsonResult("insertDemoMongDb 成功");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/insertMoreDemoMongDb", method = RequestMethod.POST)
	public @ResponseBody JsonResult insertMoreDemoMongDb(@RequestBody DemoEntity entity,HttpServletRequest request) {
		System.out.println("进入了 此 insertDemoMongDb 方法");
		try {
			demoService.insertMore();
			return new JsonResult("insertDemoMongDb 成功");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/updateDemoMongDb", method = RequestMethod.POST)
	public @ResponseBody JsonResult updateDemoMongDb(@RequestBody DemoEntity entity,HttpServletRequest request) {
		System.out.println("进入了 此 updateDemoMongDb 方法");
		if(entity==null||entity.getId()==null){
			return new JsonResult("ID不能为空", false);
		}
		try {
			demoService.update(entity);
			return new JsonResult("updateDemoMongDb 成功");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/deleteDemoMongDb", method = RequestMethod.POST)
	public @ResponseBody JsonResult deleteDemoMongDb(@RequestBody DemoEntity entity,HttpServletRequest request) {
		System.out.println("进入了 此 deleteDemoMongDb 方法");
		if(entity==null||entity.getId()==null){
			return new JsonResult("ID不能为空", false);
		}
		try {
			demoService.delete(entity);
			return new JsonResult("deleteDemoMongDb 成功"+entity.getId());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/findGroupQuery", method = RequestMethod.POST)
	public @ResponseBody JsonResult findGroupQuery(@RequestBody DemoEntity entity,HttpServletRequest request) {
		System.out.println("进入了 此 findGroupQuery 方法");
		try {
			return new JsonResult(demoService.findGroupQuery());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
}
