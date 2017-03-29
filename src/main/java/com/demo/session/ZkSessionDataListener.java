package com.demo.session;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

public class ZkSessionDataListener implements IZkDataListener {  
  
    @Override  
    public void handleDataChange(String arg0, Object arg1) throws Exception {  
    	System.out.println("进入了监听器  ZkSessionDataListener 方法");
        ZkClient client=ZkConnectionSingleton.getInstance();  
        String sid=arg0.substring(arg0.lastIndexOf("/")+1);  
        ZkSession session=(ZkSession)ZkSessionManager.getInstance().getSession(sid);  
        if(session!=null){
        	SessionMetaData meta=client.readData(arg0);  
            session.setMeta(meta); 
        }
    }  
  
    @Override  
    public void handleDataDeleted(String arg0) throws Exception {  
          
  
    }  
  
}  
