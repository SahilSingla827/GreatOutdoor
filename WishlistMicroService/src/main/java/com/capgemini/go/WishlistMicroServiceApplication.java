package com.capgemini.go;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WishlistMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishlistMicroServiceApplication.class, args);
	}

}
