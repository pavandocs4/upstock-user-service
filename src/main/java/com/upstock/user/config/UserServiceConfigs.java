package com.upstock.user.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.test.newpackage.ServiceBean;
import com.test.newpackage.TestService;
import com.upstock.client.starter.lib.autoconfigtest.ConfigTestService;


@Configuration
//@Import({ServiceBean.class, ConfigTestService.class})
//@ConditionalOnProperty(name = "my.userconfig.enabled", havingValue = "true", matchIfMissing = false)
public class UserServiceConfigs {
	
	@Bean
	//@ConditionalOnProperty(name = "my.userconfig.enabled", havingValue = "true", matchIfMissing = false)
	public TestService getTestService() {
		return new TestService();
	}
	
	
}
