package com.demo.session;

import org.I0Itec.zkclient.ZkClient;

public class ZkConnectionSingleton {

	private static String zkServer = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";  
    private static ZkClient zkClient=new ZkClient(zkServer);  
      
    public static ZkClient getInstance(){  
        return zkClient;  
    }  
}
