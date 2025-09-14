package com.upstock.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
public class UpstockUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpstockUserServiceApplication.class, args);
	}

}
