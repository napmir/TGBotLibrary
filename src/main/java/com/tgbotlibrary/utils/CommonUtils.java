package com.tgbotlibrary.utils;

import java.text.MessageFormat;

import com.tgbotlibrary.enums.CommonEnum;

public class CommonUtils {

	public static String getMethodUrl(String methodName) {
		String urlTemplate = Config.getProperty(CommonEnum.Config.Telegram.URL, "");
		String token = Config.getProperty(CommonEnum.Config.Telegram.Token, "");
		
		String url = MessageFormat.format(urlTemplate, token, methodName);
		
		return url;
	}
}
