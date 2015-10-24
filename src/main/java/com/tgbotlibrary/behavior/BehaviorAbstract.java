package com.tgbotlibrary.behavior;

import org.apache.log4j.Logger;

import com.tgbotlibrary.interactions.InteractionListenerAbstract;
import com.tgbotlibrary.response.ReplyKeyboard;

public abstract class BehaviorAbstract implements Behavior {
	protected static final Logger LOG = Logger.getLogger(InteractionListenerAbstract.class);

	protected boolean disableWebPagePreview = true;
	protected String parseMode = "";
	protected ReplyKeyboard replyKeyboard = null;

}
