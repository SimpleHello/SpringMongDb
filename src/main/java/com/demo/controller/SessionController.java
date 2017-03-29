package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.JsonResult;
import com.demo.session.AbstractSession;
import com.demo.session.ZkSession;
import com.demo.session.ZkSessionManager;

@Controller
@RequestMapping(value = "/dbsession", method = RequestMethod.POST)
public class SessionController {

	@RequestMapping(value = "/setSession", method = RequestMethod.POST)
	public @ResponseBody JsonResult setSession(HttpServletRequest request) {
		System.out.println("setSession 进入了次方法");
		try {
			ZkSession session = new ZkSession();
			String sid = (String)request.getAttribute("sid");
			session.setId(sid);
			session.setAttribute("niubi", "niuniubibi");
			return new JsonResult("设置 session 成功 key:niubi 返回sid:"+sid);
		} catch (Exception e) {
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/getSession", method = RequestMethod.POST)
	public @ResponseBody JsonResult getSession(HttpServletRequest request) {
		System.out.println("getSession 进入了次方法");
		try {
			ZkSession session = (ZkSession)request.getAttribute("session");
			String str = (String)session.getAttribute("niubi");
			
			return new JsonResult("同域获取 session 成功 key:niubi"+" 值："+ str+" sid值："+session.getId());
		} catch (Exception e) {
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
}
