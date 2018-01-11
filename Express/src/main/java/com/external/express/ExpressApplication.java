package com.external.express;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuantang
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ExpressApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressApplication.class, args);
	}
}
