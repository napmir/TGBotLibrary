package com.tgbotlibrary.behavior.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tgbotlibrary.behavior.BehaviorAbstract;
import com.tgbotlibrary.behavior.config.BestemmiaConfig;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.request.TGRequestCreator;
import com.tgbotlibrary.response.Chat;
import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.services.RequestHandler;

@Component
public class BestemminaBehavior extends BehaviorAbstract {

	@Autowired
	private RequestHandler requestHandler;

	@Autowired
	private TGRequestCreator tgRequestCreator;

	@Autowired
	private BestemmiaConfig bestemmiaConfig;

	@Override
	public void tryme(Message message) {
		Long replyToMessageId = null;
		Chat chat = message.getChat();
		Integer chatId = chat.getId();
		
		if (message.getText().toLowerCase().contains("bestemmia")) {
			String bestemmia_txt = manageBestemmie();
			if (bestemmia_txt != null) {

				TGRequest tgRequest = tgRequestCreator.sendMessage(chatId, bestemmia_txt, disableWebPagePreview,
						replyToMessageId, parseMode, replyKeyboard);
				if (tgRequest != null) {
					requestHandler.sendRequest(tgRequest);
				}
			}
		}

	}

	private String manageBestemmie() {
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(52);
		String property = "bestemmia." + random;
		String result = bestemmiaConfig.getProperty(property, "-");
		if (result.equals("-")) {
			return null;
		}
		return result;
	}

}
