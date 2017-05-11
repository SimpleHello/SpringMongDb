package com.demo.common;

import springfox.documentation.service.Tag;

public class SwaggerTag {
	
	public static Tag[] getTags() {
        Tag[] tags = {
            new Tag("app", "测试相关的API"),
            new Tag("dog", "狗相关")
        };
        return tags;
    }
}
