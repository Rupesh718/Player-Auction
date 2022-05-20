package com.javacode.serviceregistry.playerauction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryPlayerauctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryPlayerauctionApplication.class, args);
	}

}
