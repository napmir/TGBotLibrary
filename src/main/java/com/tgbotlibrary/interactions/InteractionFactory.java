package com.tgbotlibrary.interactions;

import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.services.RequestHandler;

public interface InteractionFactory {

	public Interaction createInteraction(Message message);

}
