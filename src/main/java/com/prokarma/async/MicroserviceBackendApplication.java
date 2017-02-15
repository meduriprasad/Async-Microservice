package com.prokarma.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MicroserviceBackendApplication{
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBackendApplication.class, args);
	}
}
