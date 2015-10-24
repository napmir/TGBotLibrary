package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Audio implements Response{
	
	/**
	 * String Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String id;

	/**
	 * Integer Duration of the audio in seconds as defined by sender
	 */
	@JsonProperty("duration")
	private Integer duration;

	/**
	 * String Optional. Performer of the audio as defined by sender or by audio
	 * tags
	 */
	@JsonProperty("performer")
	private Integer performer;

	/**
	 * String Optional. Title of the audio as defined by sender or by audio tags
	 */
	@JsonProperty("title")
	private String title;

	/**
	 * String Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty("mime_type")
	private String mime_type;

	/**
	 * Integer Optional. File size
	 */
	@JsonProperty("file_size")
	private Integer fileSize;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getPerformer() {
		return performer;
	}

	public void setPerformer(Integer performer) {
		this.performer = performer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMime_type() {
		return mime_type;
	}

	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

}
