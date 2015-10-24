package com.tgbotlibrary.interactions;

public interface InteractionDispatcher {

	public void enqueue(Interaction interaction);

	public void dispatch();
}
