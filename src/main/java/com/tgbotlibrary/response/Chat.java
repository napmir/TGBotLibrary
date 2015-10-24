package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Chat implements Response{

	/**
	 * 	Integer	Unique identifier for this user or bot 
	 */
	@JsonProperty("id")
	private Integer id;
	
	/**
	 * 	 String	Type of chat, can be either “private”, or “group”, or “channel”
	 */
	@JsonProperty("type")
	private String type;
	
	/**
	 * 	 String	Optional. Title, for channels and group chats
	 */
	@JsonProperty("title")
	private String title;	
	
	/**
	 * 	 String	Optional. Username, for private chats and channels if available
	 */
	@JsonProperty("username")
	private String username;		
		
	/**
	 * 	String	Optional. First name of the other party in a private chat
	 */
	@JsonProperty("first_name")
	private String firstname;
	
	/**
	 * String	Optional. Last name of the other party in a private chat
	 */
	@JsonProperty("last_name")
	private String lastname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		
		
}
