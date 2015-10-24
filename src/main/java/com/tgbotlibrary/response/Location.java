package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Location implements Response{

	/**
	 * Float	Longitude as defined by sender
	 */
	@JsonProperty("longitude")
	private Float longitude;
	
	/**
	 * Float	Latitude as defined by sender
	 */
	@JsonProperty("latitude")
	private Float latitude;

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	
	
}
