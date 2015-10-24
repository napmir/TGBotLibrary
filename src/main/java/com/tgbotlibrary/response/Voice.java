package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Voice implements Response{

	/**
	 * String Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String id;

	/**
	 * Integer Optional. File size
	 */
	@JsonProperty("file_size")
	private Integer fileSize;

	/**
	 * Integer Duration of the audio in seconds as defined by sender
	 */
	@JsonProperty("duration")
	private Integer duration;

	/**
	 * String Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty("mime_type")
	private Integer mimeType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getMimeType() {
		return mimeType;
	}

	public void setMimeType(Integer mimeType) {
		this.mimeType = mimeType;
	}

}
