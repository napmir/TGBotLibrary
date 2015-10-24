package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class ForceReply implements ReplyKeyboard{

	/**
	 * Boolean Shows reply interface to the user, as if they manually selected
	 * the bot‘s message and tapped ’Reply'
	 */
	@JsonProperty("force_reply")
	private Boolean force_reply;

	/**
	 * Boolean Optional. Use this parameter if you want to force reply from
	 * specific users only. Targets: 1) users that are @mentioned in the text of
	 * the Message object; 2) if the bot's message is a reply (has
	 * reply_to_message_id), sender of the original message.
	 */
	@JsonProperty("selective")
	private Boolean selective;

	public Boolean getForce_reply() {
		return force_reply;
	}

	public void setForce_reply(Boolean force_reply) {
		this.force_reply = force_reply;
	}

	public Boolean getSelective() {
		return selective;
	}

	public void setSelective(Boolean selective) {
		this.selective = selective;
	}

}
