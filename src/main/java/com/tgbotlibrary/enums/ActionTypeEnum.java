package com.tgbotlibrary.enums;

public enum ActionTypeEnum {
	TYPING("typing"), // FOR TEXT MESSAGES,
	UPLOAD_PHOTO("upload_photo"), // FOR PHOTOS,
	RECORD_VIDEO("record_video"), //
	UPLOAD_VIDEO("upload_video"), // FOR VIDEOS,
	RECORD_AUDIO("record_audio"), //
	UPLOAD_AUDIO("upload_audio"), // FOR AUDIO FILES,
	UPLOAD_DOCUMENT("upload_document"), // FOR GENERAL FILES,
	FIND_LOCATION("find_location");// FOR LOCATION DATA.

	private String action;

	private ActionTypeEnum(final String action) {
		this.action = action;
	}

	public String getActionToBroadcast() {
		return action;
	}
}
