package com.tgbotlibrary.interactions;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import com.tgbotlibrary.services.ServerService;

public abstract class InteractionDispatcherAbstract
		implements InteractionDispatcher, Observer, ServerService, Runnable {

	private static final Logger LOG = Logger.getLogger(InteractionDispatcherAbstract.class);

	private Thread thread;
	private boolean started;
	private long sleeptime;
	private int threadPoolSize;

	private ExecutorService executor;
	private InteractionQueue queue;

	@Override
	public void start() {
		LOG.info(" - Threadpoolsize: " + getThreadPoolSize());
		started = true;
		setExecutor(Executors.newFixedThreadPool(getThreadPoolSize()));
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		started = false;
		getExecutor().shutdown();
	}

	@Override
	public boolean isRunning() {
		return started;
	}

	@Override
	public void run() {
		int cont = 0;
		
		while (isRunning()) {
			
			if(cont % 10 == 0){
				LOG.debug("interaction dispatcher is still running...");
			}
			
			try {
				Thread.sleep(getSleeptime());
			} catch (InterruptedException e) {
				//
			}
			dispatch();
		}

		try {
			LOG.warn("Exit from interaction dispatcher");
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread = null;

	}

	@Override
	public void enqueue(Interaction interaction) {
		LOG.debug("Add to queue interaction " + interaction.toString() + " of type " + interaction.getClass().getName());
		getQueue().add(interaction);
	}

	@Override
	public abstract void dispatch();

	@Override
	public abstract void update(Observable o, Object arg);

	public InteractionQueue getQueue() {
		return queue;
	}

	@Required
	public void setQueue(InteractionQueue queue) {
		this.queue = queue;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

	public int getThreadPoolSize() {
		return threadPoolSize;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

	public long getSleeptime() {
		return sleeptime;
	}

	public void setSleeptime(long sleeptime) {
		this.sleeptime = sleeptime;
	}

}
