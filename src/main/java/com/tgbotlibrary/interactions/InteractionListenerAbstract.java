package com.tgbotlibrary.interactions;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import com.tgbotlibrary.enums.CommonEnum;
import com.tgbotlibrary.services.ServerService;
import com.tgbotlibrary.utils.Config;

public abstract class InteractionListenerAbstract implements InteractionListener, ServerService, Runnable {

	private static final Logger LOG = Logger.getLogger(InteractionListenerAbstract.class);

	private Thread thread;	
	
	private boolean started;
	private long sleeptime;

	@Override
	public void start() {
		started = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		started = false;
	}

	@Override
	public boolean isRunning() {
		return started;
	}

	@Override
	public void run() {
		while (isRunning()) {
			try {
				Thread.sleep(getSleeptime());
			} catch (InterruptedException e) {
				//
			}
			//LOG.info("Retrieving interactions....");
			retrieveInteractions();
		}
		
		try {
			thread.join();
			LOG.warn("exit from thread");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread = null;
	}

	@Override
	public abstract void retrieveInteractions();
	

	public long getSleeptime() {
		return sleeptime;
	}

	@Required
	public void setSleeptime(long sleeptime) {
		this.sleeptime = sleeptime;
	}

}
