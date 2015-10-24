package com.tgbotlibrary.enums;

import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.response.Update;
import com.tgbotlibrary.response.User;
import com.tgbotlibrary.response.UserProfilePhotos;

public enum RequestTypeEnum {
	GET_ME("getMe", User.class), //
	GET_UPDATES("getUpdates", Update.class), //
	GET_FILE("getFile", com.tgbotlibrary.response.Update .class), //
	SEND_MESSAGE("sendMessage"), //
	FORWARD_MESSAGE("forwardMessage"), //
	SEND_PHOTO("sendPhoto"), //
	SEND_AUDIO("sendAudio"), //
	SEND_DOCUMENT("sendDocument"), //
	SEND_STICKER("sendSticker"), //
	SEND_VIDEO("sendVideo"), //
	SEND_VOICE("sendVoice"), //
	SEND_LOCATION("sendLocation"), //
	SEND_CHAT_ACTION("sendChatAction", Boolean.class), //
	GET_USER_PROFILE_PHOTOS("getUserProfilePhotos", UserProfilePhotos.class), //
	SET_WEBHOOK("setWebhook");

	private Class<?> resultClass;
	private String methodName;

	public Class<?> getResultClass() {
		return resultClass;
	}

	public void setResultClass(Class<?> resultClass) {
		this.resultClass = resultClass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	private RequestTypeEnum(final String methodName) {
		this(methodName, Message.class);
	}

	private RequestTypeEnum(final String methodName, final Class<?> clazz) {
		this.resultClass = clazz;
		this.methodName = methodName;
	}
}
