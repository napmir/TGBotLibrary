package com.tgbotlibrary.prove;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import com.tgbotlibrary.behavior.Behavior;
import com.tgbotlibrary.interactions.InteractionAbstract;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.request.TGRequestCreator;
import com.tgbotlibrary.response.Chat;
import com.tgbotlibrary.response.ReplyKeyboard;
import com.tgbotlibrary.response.User;
import com.tgbotlibrary.services.RequestHandler;

public class HelloWorldInteraction extends InteractionAbstract {

	private static final Logger LOG = Logger.getLogger(HelloWorldInteraction.class);

	@Autowired
	private RequestHandler requestHandler;

	@Autowired
	private TGRequestCreator tgRequestCreator;

	@Autowired
	private HelloWorldConfig helloWorldConfig;

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void exec() {

		Map<String, Behavior> beans = applicationContext.getBeansOfType(Behavior.class);
		LOG.info("Looking for bejaviors....");
		Set<Entry<String, Behavior>> entries = beans.entrySet();
		for (Entry<String, Behavior> entry : entries) {
			LOG.info("Behavior " + entry.getKey() + " started.");
			Behavior behavior = entry.getValue();
			behavior.tryme(getMessage());
		}

	}

	private void old() {
		Chat chat = getMessage().getChat();
		Integer chatId = chat.getId();

		boolean disableWebPagePreview = true;
		Long replyToMessageId = getMessage().getId().longValue();
		String parseMode = "";
		ReplyKeyboard replyKeyboard = null;

		manageUserInfos(getMessage().getFrom());

		if (getMessage().getText().toLowerCase().contains("bestemmia")) {
			String bestemmia_txt = manageBestemmie();
			if (bestemmia_txt != null) {
				TGRequest tgRequest = tgRequestCreator.sendMessage(chatId, bestemmia_txt, disableWebPagePreview, null,
						parseMode, replyKeyboard);
				if (tgRequest != null) {
					getRequestHandler().sendRequest(tgRequest);
					return;
				}
			}
		}
		if (getMessage().getText().toLowerCase().contains("insulta")) {

			int index = getMessage().getText().toLowerCase().indexOf("insulta") + "insulta".length();
			String tempMessage = getMessage().getText().toLowerCase().substring(index).trim();
			int spaceIndex = tempMessage.indexOf(" ");
			String name = tempMessage;
			if (spaceIndex >= 0) {
				name = tempMessage.substring(0, spaceIndex);
			}

			String bestemmia_txt = manageInsulti(name);
			if (bestemmia_txt != null) {
				TGRequest tgRequest = tgRequestCreator.sendMessage(chatId, bestemmia_txt, disableWebPagePreview, null,
						parseMode, replyKeyboard);
				if (tgRequest != null) {
					getRequestHandler().sendRequest(tgRequest);
					return;
				}
			}
		}
	}

	private String manageBestemmie() {
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(52);
		String property = "bestemmia." + random;
		String result = helloWorldConfig.getProperty(property, "-");
		if (result.equals("-")) {
			return null;
		}
		return result;
	}

	private String manageInsulti(String name) {
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(28);
		String property = "insulto." + random;
		String result = helloWorldConfig.getProperty(property, "-");
		if (result.equals("-")) {
			return null;
		}

		result = result.replace("{0}", name);

		return result;
	}

	public String manageUserInfos(final User user) {
		String text = null;
		String property = "userinfos.";
		if (user != null) {
			String username = user.getUsername();
			String firstname = getMessage().getFrom().getFirstname();
			String lastname = getMessage().getFrom().getLastname();

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

			text = helloWorldConfig.getProperty(property, "-");
		}

		return null;
	}

	public RequestHandler getRequestHandler() {
		return requestHandler;
	}

	@Required
	public void setRequestHandler(RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

}
