package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SwaggerInterceptor implements HandlerInterceptor {

	@Value("${scloud.develop}")
	private String develop;
	
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) 
	    throws Exception {
        if (develop!= null&&"develop".equals(develop)) {
        	return true;
        }
        res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {
    }
}