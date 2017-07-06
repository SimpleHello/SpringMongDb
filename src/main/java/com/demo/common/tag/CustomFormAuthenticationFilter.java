package com.demo.common.tag;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{


    @Override
   protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
           throws Exception {
    	System.out.println("到此---  xxxx -");
       return super.onAccessDenied(request, response);
   }
}