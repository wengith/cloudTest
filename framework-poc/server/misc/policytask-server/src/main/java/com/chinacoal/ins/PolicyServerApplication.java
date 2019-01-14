package com.chinacoal.ins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: wen
 * @date: 2018/10/18 15:32
 * @description: 启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class PolicyServerApplication{

	public static void main(String[] args) {
		SpringApplication.run(PolicyServerApplication.class, args);
	}
}
