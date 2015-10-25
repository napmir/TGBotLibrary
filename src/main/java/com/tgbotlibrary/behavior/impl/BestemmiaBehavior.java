package com.tgbotlibrary.behavior.impl;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tgbotlibrary.behavior.BehaviorAbstract;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.request.TGRequestCreator;
import com.tgbotlibrary.response.Chat;
import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.services.RequestHandler;
import com.tgbotlibrary.utils.Config;

@Component
public class BestemmiaBehavior extends BehaviorAbstract implements FileBehavior {

	@Autowired
	private RequestHandler requestHandler;

	@Autowired
	private TGRequestCreator tgRequestCreator;

	private final static String PATH_CONFIG = "bestemmia.path";
	private final static String RANDOM_CONFIG="bestemmie";
	private static final String CONTAINS_STRING = "bestemmia";

	@Override
	public void tryme(Message message) {
		Long replyToMessageId = null;
		Chat chat = message.getChat();
		Integer chatId = chat.getId();

		if (message.getText() != null && message.getText().toLowerCase().contains(CONTAINS_STRING)) {
			Random randomGenerator = new Random();
			int random = randomGenerator.nextInt(10);
			if (random == 1) {
				photo(replyToMessageId, chatId);
			} else {
				message(replyToMessageId, chatId);
			}
		}

	}

	private void photo(Long replyToMessageId, Integer chatId) {
		String _path = Config.getProperty(PATH_CONFIG,
				"/Users/mirko/Documents/workspace/telegram/TGBotLibrary/src/main/resources/photos/funny");

		String[] extensions = { "jpg" };

		List<String> files = getFilesName(_path, extensions);

		if (files != null && !files.isEmpty()) {
			Random randomGenerator = new Random();
			int random = randomGenerator.nextInt(files.size());
			File file = getFile(files.get(random));
			if (file != null) {

				String caption = "";
				TGRequest tgRequest = tgRequestCreator.sendPhoto(chatId, file, caption, replyToMessageId,
						replyKeyboard);

				if (tgRequest != null) {
					requestHandler.sendRequest(tgRequest);
				}
			}

		}
	}

	private void message(Long replyToMessageId, Integer chatId) {
		String bestemmia_txt = manageBestemmie();
		if (bestemmia_txt != null) {

			TGRequest tgRequest = tgRequestCreator.sendMessage(chatId, bestemmia_txt, disableWebPagePreview,
					replyToMessageId, parseMode, replyKeyboard);
			if (tgRequest != null) {
				requestHandler.sendRequest(tgRequest);
			}
		}
	}

	private String manageBestemmie() {
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(Config.getProperty(RANDOM_CONFIG, 120));
		String property = "bestemmia." + random;
		String result = Config.getProperty(property, "-");
		if (result.equals("-")) {
			return null;
		}
		return result;
	}

}
