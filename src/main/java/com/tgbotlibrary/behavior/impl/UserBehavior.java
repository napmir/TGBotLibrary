package com.tgbotlibrary.behavior.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tgbotlibrary.behavior.BehaviorAbstract;
import com.tgbotlibrary.behavior.config.InsultaConfig;
import com.tgbotlibrary.behavior.config.UserConfig;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.request.TGRequestCreator;
import com.tgbotlibrary.response.Chat;
import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.response.User;
import com.tgbotlibrary.services.RequestHandler;

@Component
public class UserBehavior extends BehaviorAbstract {

	@Autowired
	private RequestHandler requestHandler;

	@Autowired
	private TGRequestCreator tgRequestCreator;

	@Autowired
	private UserConfig userConfig;

	@Override
	public void tryme(Message message) {
		
		Long replyToMessageId = null;
		Chat chat = message.getChat();
		Integer chatId = chat.getId();
		
		User user = message.getFrom();

		String text = null;
		String property = "userinfos.";

		if (user != null) {
			String username = user.getUsername();
			String firstname = user.getFirstname();
			String lastname = user.getLastname();

			if (StringUtils.isEmpty(username)) {

			} else if (StringUtils.isEmpty(firstname)) {

				if (firstname.toLowerCase().contains("alessandro")) {
					property = property + "alessandro";
				} else if (firstname.toLowerCase().contains("paolo")) {
					property = property + "paolo";
				} else if (firstname.toLowerCase().contains("matteo")) {
					property = property + "matteo";
				}

			} else if (StringUtils.isEmpty(lastname)) {

			}

			text = userConfig.getProperty(property, "-");
			if (!text.equalsIgnoreCase("-")) {
				TGRequest tgRequest = tgRequestCreator.sendMessage(chatId, text, disableWebPagePreview, replyToMessageId, parseMode,
						replyKeyboard);
				if (tgRequest != null) {
					requestHandler.sendRequest(tgRequest);
				}
			}
		}

	}

}
