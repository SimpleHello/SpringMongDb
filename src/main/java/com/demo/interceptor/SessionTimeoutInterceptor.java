package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionTimeoutInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) 
	    throws Exception {
        HttpSession session = req.getSession();
        System.out.println("进入了 SessionTimeoutInterceptor 方法");
        /** 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (session.getAttribute(Const.SESSION_USER) == null) {
            if(req.getHeader("x-requested-with") != null && 
                    req.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
            // 根据请求的 Header 得出该请求是 AJAX 异步请求，则在响应中设置
            // HTTP状态码，标注 Session 超时，由前端来处理页面重定向
                res.setStatus(HttpStatusCode.SESSION_TIME_OUT);
            } else {
            // 该请求为页面跳转请求，则直接在响应中进行重定向
                res.sendRedirect(req.getContextPath() + "index.jsp");
            }
            return false;
        }
        */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {
    }
}