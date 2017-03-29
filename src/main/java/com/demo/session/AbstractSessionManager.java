package com.demo.session;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractSessionManager {
	
	private Map sessions=new HashMap();
	
	public AbstractSessionManager(){}
	
	public HttpSession getSession(String sid){
		return (HttpSession)sessions.get(sid);
	}
	
	public void addSession(HttpSession session,String sid){
		this.sessions.put(sid, session);
	}
	
	public abstract void loadSession();
	
	public Map getAllSession(){
		return sessions;
	}
	
	
	public String getSessionIdByCookie(HttpServletRequest request){
		String sid = request.getParameter("SESSIONID");
		if (sid == null || sid.equals("")) {
			return null;
		}
		return sid;
	}
}
