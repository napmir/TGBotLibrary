package com.tgbotlibrary.interactions;

import java.util.Observable;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

public class InteractionDispatcherImpl extends InteractionDispatcherAbstract {

	private static final Logger LOG = Logger.getLogger(InteractionDispatcherImpl.class);

	private long taskListCapacity;

	private ConcurrentMap<String, InteractionTask> taskList = new ConcurrentLinkedHashMap.Builder<String, InteractionTask>()
			.maximumWeightedCapacity(getTaskListCapacity()).build();
	
	@Override
	public void dispatch() {
		//LOG.info("dispatch method");
		while (!getQueue().isEmpty()) {
			InteractionTaskAbstract task = new InteractionTaskImpl(getQueue().poll());
			task.addObserver(this);
			taskList.put(String.valueOf(task.getInteraction().hashCode()), task);
			getExecutor().execute(task);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		LOG.info("update method");
		final InteractionTaskAbstract task = (InteractionTaskAbstract) o;
		final String observableKey = String.valueOf(task.getInteraction().hashCode());
		if (taskList.containsKey(observableKey)) {
			taskList.remove(observableKey);
			LOG.debug("Pending tasks: " + taskList.size() + "...");
		} else {
			// LOG.error("Could not find {Task:" + observableKey + "} in
			// taskList");
		}

	}

	public long getTaskListCapacity() {
		return taskListCapacity;
	}

	public void setTaskListCapacity(long taskListCapacity) {
		this.taskListCapacity = taskListCapacity;
	}

}
