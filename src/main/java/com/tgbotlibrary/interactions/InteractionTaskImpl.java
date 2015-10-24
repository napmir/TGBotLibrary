package com.tgbotlibrary.interactions;

import org.apache.log4j.Logger;

public class InteractionTaskImpl extends InteractionTaskAbstract {

	private static final Logger LOG = Logger.getLogger(InteractionTaskImpl.class);

	public InteractionTaskImpl(Interaction interaction) {
		super(interaction);
	}

	@Override
	public void processInteraction() {
		try {
			// LOG.trace("\tSTART processing command {" + command + "}");
			Thread.sleep(20);
			getInteraction().exec();
			// LOG.trace("\tEND processing command {" + command + "}");
		} catch (InterruptedException e) {
			// LOG.error(e);
		}
	}

	@Override
	public void notifyObserver() {
		setChanged();
		notifyObservers();
	}

}
