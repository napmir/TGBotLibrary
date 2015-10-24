package com.tgbotlibrary.interactions;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class InteractionQueueImpl implements InteractionQueue {

	private Queue<Interaction> interactionQueue ;
	
	public InteractionQueueImpl() {
		interactionQueue = new ConcurrentLinkedQueue<Interaction>();
	}
	
	@Override
	public void add(Interaction interaction) {
		interactionQueue.add(interaction);
	}

	@Override
	public Interaction poll() {
		return interactionQueue.poll();
	}

	@Override
	public int size() {
		return interactionQueue.size();
	}

	@Override
	public boolean isEmpty() {
		return interactionQueue.isEmpty();
	}

	@Override
	public boolean contains(Interaction interaction) {
		return interactionQueue.contains(interaction);
	}
}
