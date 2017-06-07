package com.weyland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoApplication {
//public class DemoApplication extends SpringBootServletInitializer {
//长的打包时启用，短的开发时启用
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
