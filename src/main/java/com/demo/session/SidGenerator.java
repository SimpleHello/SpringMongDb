package com.demo.session;

import java.util.UUID;

public class SidGenerator {
	public static String generateSid(){  
        return UUID.randomUUID().toString();  
    } 
}
