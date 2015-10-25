package com.tgbotlibrary.utils;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

@Configuration
// @PropertySource("file:src/main/resources/config.properties")
// @PropertySource("file:config/**.properties")
@PropertySources({ @PropertySource(value = "file:src/main/resources/config.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:src/main/resources/insulta.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:src/main/resources/bestemmia.properties", ignoreResourceNotFound = true),

		@PropertySource(value = "file:config/config.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:config/insulta.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:config/bestemmia.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:config/user.properties", ignoreResourceNotFound = true)

})
@Component
public class Config {

	private static Environment env;

	@Autowired
	private Environment tmpEnv;

	@PostConstruct
	public void init() {
		Config.env = tmpEnv;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() throws IOException {
		PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertyConfigurer
				.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath:**.properties"));
		return propertyConfigurer;
	}

	public static String getProperty(String propertyKey, String defaultValue) {
		//
		// String property = "${propertyKey}";
		// if(!StringUtils.isEmpty(property)){
		// return property;
		// }
		// return defaultValue;

		return env.getProperty(propertyKey, defaultValue);
	}

	public static boolean getProperty(String propertyKey, boolean defaultValue) {
		// String value = env.getProperty(propertyKey,
		// String.valueOf(defaultValue));

		String value = getProperty(propertyKey, String.valueOf(defaultValue));

		boolean booleanValue = Boolean.parseBoolean(value);

		return booleanValue;
	}

	public static int getProperty(String propertyKey, int defaultValue) {
		// String value = env.getProperty(propertyKey,
		// String.valueOf(defaultValue));

		String value = getProperty(propertyKey, String.valueOf(defaultValue));

		try {
			int intValue = Integer.parseInt(value);
			return intValue;
		} catch (NumberFormatException e) {
			//
		}

		return defaultValue;
	}

	public static long getProperty(String propertyKey, long defaultValue) {
		// String value = env.getProperty(propertyKey,
		// String.valueOf(defaultValue));

		String value = getProperty(propertyKey, String.valueOf(defaultValue));
		try {
			long intValue = Long.parseLong(value);
			return intValue;
		} catch (NumberFormatException e) {
			//
		}

		return defaultValue;
	}

}
