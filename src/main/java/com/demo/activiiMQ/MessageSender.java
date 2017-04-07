package com.demo.activiiMQ;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service
public class MessageSender {
	
	@Value("${activeMQ.url}")
    private String url;
	
	@Value("${activeMQ.user}")
    private String user;
	
	@Value("${activeMQ.password}")
    private String password;
	
	@Value("${activeMQ.sendQuartzQuene}")
    private String quene;
	
	public void sendMessage(MessageEntity entity){
		  ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory( user, password, url);  
	        Session session = null;  
	        Destination sendQueue;  
	        Connection connection = null;   
	        try {  
	            connection = connectionFactory.createConnection();  
	  
	            connection.start();  
	            System.out.println("消息 发送开始");  
	  
	          
                session = connection.createSession(true,  
                        Session.SESSION_TRANSACTED);  
  
                sendQueue = session.createQueue(quene);  
                MessageProducer sender = session.createProducer(sendQueue);  
                TextMessage outMessage = session.createTextMessage();  
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                entity.setId(UUID.randomUUID().toString());
                String message = JSON.toJSONString(entity);
                outMessage.setText(message);  
                sender.send(outMessage);  
                session.commit();  
  
                sender.close();  
	        
	            connection.close();  
	            System.out.println("消息 发送完成");  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } 
	}
}
