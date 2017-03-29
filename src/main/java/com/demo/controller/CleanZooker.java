package com.demo.controller;

import java.util.Date;
import java.util.List;

import org.I0Itec.zkclient.ZkClient;

import com.demo.session.SessionMetaData;
import com.demo.session.ZkConnectionSingleton;
import com.demo.session.ZkSession;
import com.demo.session.ZkSessionHelper;

public class CleanZooker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ZkClient client=ZkConnectionSingleton.getInstance();  
	            List<String> sessionList=client.getChildren(ZkSessionHelper.root);  
	            for(int i=0,len=sessionList.size();i<len;i++){  
	                String sid=sessionList.get(i);  
	                SessionMetaData meta=client.readData(ZkSessionHelper.root+"/"+sid);  
	                ZkSession session=new ZkSession(); 
	                // 若 该节点 无 session  则删除该节点
                    client.deleteRecursive(ZkSessionHelper.root+"/"+sid); 
                    System.out.println("删除节点:"+sid); 
	            }  
  
	}

}
