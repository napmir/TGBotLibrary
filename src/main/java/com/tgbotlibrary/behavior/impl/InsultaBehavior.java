package com.tgbotlibrary.behavior.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tgbotlibrary.behavior.BehaviorAbstract;
import com.tgbotlibrary.behavior.config.InsultaConfig;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.request.TGRequestCreator;
import com.tgbotlibrary.response.Chat;
import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.services.RequestHandler;

@Component
public class InsultaBehavior extends BehaviorAbstract {

	@Autowired
	private RequestHandler requestHandler;

	@Autowired
	private TGRequestCreator tgRequestCreator;

	@Autowired
	private InsultaConfig insultaConfig;

	@Override
	public void tryme(Message message) {
		Long replyToMessageId = null;
		Chat chat = message.getChat();
		Integer chatId = chat.getId();
		
		
		if (message.getText().toLowerCase().contains("insulta")) {

			int index = message.getText().toLowerCase().indexOf("insulta") + "insulta".length();
			String tempMessage = message.getText().toLowerCase().substring(index).trim();
			int spaceIndex = tempMessage.indexOf(" ");
			String name = tempMessage;
			if (spaceIndex >= 0) {
				name = tempMessage.substring(0, spaceIndex);
			}

			String bestemmia_txt = manageInsulti(name);
			if (bestemmia_txt != null) {
				TGRequest tgRequest = tgRequestCreator.sendMessage(chatId, bestemmia_txt, disableWebPagePreview, replyToMessageId,
						parseMode, replyKeyboard);
				if (tgRequest != null) {
					requestHandler.sendRequest(tgRequest);
				}
			}
		}

	}

	private String manageInsulti(String name) {
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(28);
		String property = "insulto." + random;
		String result = insultaConfig.getProperty(property, "-");
		if (result.equals("-")) {
			return null;
		}

		result = result.replace("{0}", name);

		return result;
	}
}
