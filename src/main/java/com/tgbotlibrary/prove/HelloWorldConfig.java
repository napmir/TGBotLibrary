package com.tgbotlibrary.prove;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:examplebot.properties")
@Component
public class HelloWorldConfig {

	private static Environment env;

	@Autowired
	private Environment tmpEnv;

	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		HelloWorldConfig.env = tmpEnv;
	}

	public static String getProperty(String propertyKey, String defaultValue) {
		return env.getProperty(propertyKey, defaultValue);
	}

}
