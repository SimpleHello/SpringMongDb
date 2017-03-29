package com.demo.session;

import java.io.Serializable;

public class SessionMetaData implements Serializable{  
    /**
	 * 
	 */
	private static final long serialVersionUID = -8084485721698463251L;
	
	private long createTime;  
    private String sid;  
    private long lastAccessedTime;  
    private int maxInactiveInterval;  
    private boolean isnew;  
  
    public long getCreateTime() {  
        return createTime;  
    }  
  
    public void setCreateTime(long createTime) {  
        this.createTime = createTime;  
    }  
  
    public String getSid() {  
        return sid;  
    }  
  
    public void setSid(String sid) {  
        this.sid = sid;  
    }  
  
    public long getLastAccessedTime() {  
        return lastAccessedTime;  
    }  
  
    public void setLastAccessedTime(long lastAccessedTime) {  
        this.lastAccessedTime = lastAccessedTime;  
    }  
  
    public int getMaxInactiveInterval() {  
        return maxInactiveInterval;  
    }  
  
    public void setMaxInactiveInterval(int maxInactiveInterval) {  
        this.maxInactiveInterval = maxInactiveInterval;  
    }  
  
    public boolean isIsnew() {  
        return isnew;  
    }  
  
    public void setIsnew(boolean isnew) {  
        this.isnew = isnew;  
    }  
  
}  