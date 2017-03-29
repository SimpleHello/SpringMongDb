package com.demo.session;

import java.util.Date;
import java.util.List;

import org.I0Itec.zkclient.ZkClient;

public class ZkSessionCleaner extends Thread {  
  
    @Override  
    public void run() {  
        ZkClient client=ZkConnectionSingleton.getInstance();  
        while(true){  
            List<String> sessionList=client.getChildren(ZkSessionHelper.root);  
            for(int i=0,len=sessionList.size();i<len;i++){  
                String sid=sessionList.get(i);  
                SessionMetaData meta=client.readData(ZkSessionHelper.root+"/"+sid);  
                ZkSession session=new ZkSession(); 
                if(meta==null || (new Date().getTime()- meta.getLastAccessedTime())>meta.getMaxInactiveInterval()){  //meta.getMaxInactiveInterval()
                	// 若 该节点 无 session  则删除该节点
                    client.deleteRecursive(ZkSessionHelper.root+"/"+sid); 
                    System.out.println("删除节点:"+sid);
                }  
            }  
            try {  
                Thread.sleep(30000);  
            } catch (InterruptedException e) {  
            }  
        }  
    }  
  
}  