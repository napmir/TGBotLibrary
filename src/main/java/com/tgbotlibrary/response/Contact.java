package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Contact implements Response{
	/**
	 * String Contact's phone number
	 */
	@JsonProperty("phone_number")
	private String phoneNumber;

	/**
	 * String Contact's first name
	 */
	@JsonProperty("first_name")
	private String firstName;

	/**
	 * String Optional. Contact's last name
	 */
	@JsonProperty("last_name")
	private String lastName;

	/**
	 * Integer Optional. Contact's user identifier in Telegram
	 */
	@JsonProperty("user_id")
	private Integer userId;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
