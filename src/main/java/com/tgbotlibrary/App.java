package com.tgbotlibrary;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tgbotlibrary.utils.JsonUtils;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) {
		LOG.info("Starting application...");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		TGBotApplication application = context.getBean(TGBotApplication.class);
		application.start();
		
		LOG.info("Application started");
	}
}
