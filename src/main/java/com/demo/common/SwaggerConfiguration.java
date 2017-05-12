package com.demo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration  
@EnableSwagger2  
public class SwaggerConfiguration {
	
	@Value("${version}")
	String version;
    @Bean  
    public Docket api() {  
    	Docket doctor = new Docket(DocumentationType.SWAGGER_2) 
    			.tags(new Tag("key值", "value值"),SwaggerTag.getTags())
                .select()  
                .apis(RequestHandlerSelectors.any())  
                .paths(PathSelectors.any())  
                .build();
    	
    	doctor.apiInfo(apiInfo());
        return doctor;  
    }  
    
    
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试用API管理项目")
                .description("scloud各个api管理")
                .termsOfServiceUrl("")
                .version(version)
                .build();
    }

}  