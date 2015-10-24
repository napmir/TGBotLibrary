package com.tgbotlibrary.interactions;

import java.util.Observable;


public abstract class InteractionTaskAbstract extends Observable implements InteractionTask, Runnable {

	private Interaction interaction;

	public InteractionTaskAbstract(final Interaction interaction) {
		this.setInteraction(interaction);
	}

	@Override
	public void run() {
		processInteraction();
		notifyObserver();
	}

	@Override
	public abstract void processInteraction();

	/**
	 * Method used to notify all the hooked {@link Observer} clients when this
	 * Observable object had finished processing the Interaction.
	 */
	public abstract void notifyObserver();

	public Interaction getInteraction() {
		return interaction;
	}

	public void setInteraction(Interaction interaction) {
		this.interaction = interaction;
	}

	

}
