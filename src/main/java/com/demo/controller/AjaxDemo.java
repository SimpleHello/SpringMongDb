package com.demo.controller;

import java.awt.Font;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.activiiMQ.MessageEntity;
import com.demo.activiiMQ.MessageSender;
import com.demo.common.JsonResult;
import com.demo.util.png.FontImage;

@Controller
@RequestMapping(value = "/ajax", method = RequestMethod.POST)
public class AjaxDemo {
	
	@Autowired
	MessageSender messageSender;
	
	@RequestMapping(value = "/getSomeAjax/{name}", method = RequestMethod.POST)
	public @ResponseBody JsonResult getSomeAjax(@PathVariable String name,HttpServletRequest request) {
		try {
			System.out.println("接收到参数:"+name);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", name);
			System.out.println("最后结果：传值："+name+" 返回值:"+name);
			return new JsonResult(map);
		} catch (Exception e) {
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/createPng", method = RequestMethod.POST)
	public @ResponseBody JsonResult createPng(HttpServletRequest request) {
		try {
			String path =getFilePath();
			FontImage.createImage("请A1003到3号窗口", new Font("宋体", Font.BOLD, 30), new File(path), 4096, 64);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("result", "创建成功");
			return new JsonResult(map);
		} catch (Exception e) {
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public @ResponseBody JsonResult sendMessage(MessageEntity entity,HttpServletRequest request) {
		try {
			System.out.println("接收到参数:"+entity);
			messageSender.sendMessage(entity);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", "消息发送成功");
			return new JsonResult(map);
		} catch (Exception e) {
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	private String getFilePath(){
		String file = "E:\\111\\aaa.png";
		Map<String, String> map = System.getenv();
		String os = map.get("OS");
		System.out.println("当前系统："+os);
		if(os==null||!os.contains("Windows")){
			file="/home/data/aaa.png";
		}
		return file;
	}
	
}
