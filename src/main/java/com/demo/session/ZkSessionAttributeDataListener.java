 
package com.demo.session;

import org.I0Itec.zkclient.IZkDataListener;

public class ZkSessionAttributeDataListener implements IZkDataListener {  
  
    @Override  
    public void handleDataChange(String arg0, Object arg1) throws Exception {
    	System.out.println("进入了监听器  ZkSessionAttributeDataListener 方法");
        String name=arg0.substring(arg0.lastIndexOf("/")+1);  
        Object value=arg1;  
        String prefix=arg0.substring(0,arg0.lastIndexOf("/"));  
        String sid=prefix.substring(prefix.lastIndexOf("/")+1);  
        ((ZkSession)ZkSessionManager.getInstance().getSession(sid)).localSetAttribute(name, value);  
          
    }  
  
    @Override  
    public void handleDataDeleted(String arg0) throws Exception {  
  
    }  
  
}  
