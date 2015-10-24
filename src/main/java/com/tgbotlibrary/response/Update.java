package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Update implements Response{

	/**
	 * Integer The update‘s unique identifier. Update identifiers start from a
	 * certain positive number and increase sequentially. This ID becomes
	 * especially handy if you’re using Webhooks, since it allows you to ignore
	 * repeated updates or to restore the correct update sequence, should they
	 * get out of order.
	 */
	@JsonProperty("update_id")
	private Integer id;

	/**
	 * Message Optional. New incoming message of any kind — text, photo,
	 * sticker, etc
	 */
	@JsonProperty("message")
	private Message message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
