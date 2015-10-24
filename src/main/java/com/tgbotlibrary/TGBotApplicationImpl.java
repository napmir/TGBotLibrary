package com.tgbotlibrary;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgbotlibrary.interactions.InteractionDispatcherImpl;
import com.tgbotlibrary.interactions.InteractionListenerImpl;

@Service
public class TGBotApplicationImpl implements TGBotApplication {
	private static final Logger LOG = Logger.getLogger(TGBotApplicationImpl.class);

	@Autowired
	private InteractionDispatcherImpl dispatcher;

	@Autowired
	private InteractionListenerImpl listener;

	public void start() {
		LOG.info("Starting interaction dispatcher");

		dispatcher.start();

		LOG.info("Interaction dispatcher started");

		LOG.info("Starting interaction listener");

		listener.start();

		LOG.info("Interaction listener started");

	}
}
