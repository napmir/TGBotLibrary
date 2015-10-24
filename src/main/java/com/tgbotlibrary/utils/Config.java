package com.tgbotlibrary.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("file:src/main/resources/config.properties")
@Component
public class Config {

	private static Environment env;

	@Autowired
	private Environment tmpEnv;

	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		Config.env = tmpEnv;
	}


	public static String getProperty(String propertyKey, String defaultValue) {
		return env.getProperty(propertyKey, defaultValue);
	}

	public static boolean getProperty(String propertyKey, boolean defaultValue) {
		String value = env.getProperty(propertyKey, String.valueOf(defaultValue));
		boolean booleanValue = Boolean.parseBoolean(value);

		return booleanValue;
	}

	public static int getProperty(String propertyKey, int defaultValue) {
		String value = env.getProperty(propertyKey, String.valueOf(defaultValue));

		try {
			int intValue = Integer.parseInt(value);
			return intValue;
		} catch (NumberFormatException e) {
			//
		}

		return defaultValue;
	}

	public static long getProperty(String propertyKey, long defaultValue) {
		String value = env.getProperty(propertyKey, String.valueOf(defaultValue));

		try {
			long intValue = Long.parseLong(value);
			return intValue;
		} catch (NumberFormatException e) {
			//
		}

		return defaultValue;
	}





	
}
