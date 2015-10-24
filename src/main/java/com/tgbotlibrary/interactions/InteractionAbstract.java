package com.tgbotlibrary.interactions;

import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.services.RequestHandler;

public abstract class InteractionAbstract implements Interaction {

	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}


	@Override
	public abstract void exec();
}
