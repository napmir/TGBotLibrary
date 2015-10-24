package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Sticker implements Response {

	/**
	 * String Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String id;

	/**
	 * Integer Sticker width
	 */
	@JsonProperty("width")
	private Integer width;

	/**
	 * Integer Sticker height
	 */
	@JsonProperty("height")
	private Integer height;

	/**
	 * Integer Optional. File sizeInteger Unique message identifier
	 */
	@JsonProperty("file_size")
	private Integer fileSize;

	/**
	 * PhotoSize Optional. Sticker thumbnail in .webp or .jpg format
	 */
	@JsonProperty("thumb")
	private PhotoSize thumb;

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

}
