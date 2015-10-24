package com.tgbotlibrary.behavior.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.tgbotlibrary.behavior.BehaviorAbstract;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.request.TGRequestCreator;
import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.services.RequestHandler;

@Component
public class VignettaFileBehavior extends BehaviorAbstract implements FileBehavior {

	@Autowired
	private RequestHandler requestHandler;

	@Autowired
	private TGRequestCreator tgRequestCreator;

	private final String path = "resources/photos/funny";

	@Override
	public void tryme(Message message) {

		if (message.getText().toLowerCase().contains("ridere")) {

			String _path = "/Users/mirko/Documents/workspace/telegram/TGBotLibrary/src/main/resources/photos/funny";
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
