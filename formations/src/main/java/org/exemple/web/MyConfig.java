package org.exemple.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	@Bean
	public ResourceConfig getJersey() {
		ResourceConfig config= new ResourceConfig();
		config.register(EtudiantRestService.class);
		return config;
	}
	

}
