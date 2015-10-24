package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Video implements Response{

	/**
	 * String Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String id;

	/**
	 * Integer Video width as defined by sender
	 */
	@JsonProperty("width")
	private Integer width;

	/**
	 * Integer Video height as defined by sender
	 */
	@JsonProperty("height")
	private Integer height;

	/**
	 * Integer Optional. File sizeInteger Unique message identifier
	 */
	@JsonProperty("file_size")
	private Integer fileSize;

	/**
	 * PhotoSize Optional. Video thumbnail
	 */
	@JsonProperty("thumb")
	private PhotoSize thumb;

	/**
	 * Integer Duration of the video in seconds as defined by sender
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

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
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
