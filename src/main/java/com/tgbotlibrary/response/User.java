package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author mirko
 */
public class User implements Response{

	/*
	 * 	Integer	Unique identifier for this user or bot 
	 */
	@JsonProperty("id")
	private Integer id;
	
	/*
	 * 	String	User‘s or bot’s first name
	 */
	@JsonProperty("first_name")
	private String firstname;
	
	/*
	 * String	Optional. User‘s or bot’s last name
	 */
	@JsonProperty("last_name")
	private String lastname;
	
	/*
	 *	String	Optional. User‘s or bot’s username 
	 */
	@JsonProperty("username")
	private String username;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
