package com.demo.session;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.I0Itec.zkclient.ZkClient;

public class ZkSessionFilter extends AbstractSessionFilter {  
  
      
    private void newSession(HttpServletRequest request, HttpServletResponse response) {  
        HttpSession session=new ZkSession();  
        String sid=SidGenerator.generateSid();  
        ((AbstractSession)session).setId(sid);  
        ZkSessionManager.getInstance().addSession(session, sid);  
        ZkSessionHelper.addSession(((AbstractSession)session).getMeta());  
        Cookie cookie=new Cookie("sid",sid);  
        cookie.setMaxAge((int)SessionChangeListener.getTimeout());  
        response.addCookie(cookie);  
        request.setAttribute("sid", sid);  
          
  
    }  

    @Override  
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response) { 
    	System.out.println("进入了拦截器 方法");
        AbstractSessionManager sessionManager=ZkSessionManager.getInstance();  
        String sid=sessionManager.getSessionIdByCookie((HttpServletRequest)request);  
        if(sid==null || sid.equals("")){ 
//        	  getSessionId((HttpServletRequest)request);
            newSession((HttpServletRequest)request,(HttpServletResponse)response);  
        }else{  
            AbstractSession session=(AbstractSession)sessionManager.getSession(sid);  
            if(session!=null){  
                session.setLastAccessedTime(new Date().getTime());  
                ZkClient client=ZkConnectionSingleton.getInstance();  
                client.writeData(ZkSessionHelper.root+"/"+sid, session.getMeta()); 
                ZkSessionManager.getInstance().loadSession();
                AbstractSession sessions=(AbstractSession)ZkSessionManager.getInstance().getSession(sid); 
                request.setAttribute("session", sessions);
            }else{  
                newSession((HttpServletRequest)request,(HttpServletResponse)response);  
            }  
        }  
          
    }  
  
}  
