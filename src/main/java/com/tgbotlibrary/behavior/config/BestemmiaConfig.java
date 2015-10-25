package com.tgbotlibrary.behavior.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@Configuration
//@PropertySource("classpath:examplebot.properties")
//@PropertySource("file:config/bestemmia.properties")
//@Component
public class BestemmiaConfig {

	@Autowired
	private Environment env;

	public String getProperty(String propertyKey, String defaultValue) {
		return env.getProperty(propertyKey, defaultValue);
	}

}
