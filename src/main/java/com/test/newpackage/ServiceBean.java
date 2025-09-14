package com.test.newpackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBean {
	@Bean
	public TestService getServiceBean() {
		return new TestService();
	}

}
