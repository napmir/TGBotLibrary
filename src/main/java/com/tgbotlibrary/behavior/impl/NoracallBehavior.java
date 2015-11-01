package com.tgbotlibrary.behavior.impl;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tgbotlibrary.behavior.BehaviorAbstract;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.request.TGRequestCreator;
import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.services.RequestHandler;
import com.tgbotlibrary.utils.Config;

@Component
public class NoracallBehavior extends BehaviorAbstract implements FileBehavior {

	@Autowired
	private RequestHandler requestHandler;

	@Autowired
	private TGRequestCreator tgRequestCreator;

	private final static String PATH_CONFIG = "noracall.path";

	@Override
	public void tryme(Message message) {

		boolean contains = message.getText().toLowerCase().contains("noracall");
		
		if (contains) {
			String _path = Config.getProperty(PATH_CONFIG,
					"/Users/mirko/Documents/workspace/telegram/TGBotLibrary/src/main/resources/photos/mosconi");

			String[] extensions = { "jpg" };

			List<String> files = getFilesName(_path, extensions);

			if (files != null && !files.isEmpty()) {
				Random randomGenerator = new Random();
				int random = randomGenerator.nextInt(files.size());
				File file = getFile(files.get(random));
				if (file != null) {

					long chatId = message.getChat().getId();
					String caption = "";
					Long replyToMessageId = null;
					TGRequest tgRequest = tgRequestCreator.sendPhoto(chatId, file, caption, replyToMessageId,
							replyKeyboard);

					if (tgRequest != null) {
						requestHandler.sendRequest(tgRequest);
					}
				}

			}

		}
	}

}
