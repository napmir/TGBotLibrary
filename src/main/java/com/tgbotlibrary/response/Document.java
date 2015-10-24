package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Document implements Response{

	/**
	 * String Unique file identifier
	 */
	@JsonProperty("file_id")
	private String id;

	/**
	 * PhotoSize Optional. Document thumbnail as defined by sender
	 */
	@JsonProperty("thumb")
	private PhotoSize thumb;

	/**
	 * String Optional. Original filename as defined by sender
	 */
	@JsonProperty("file_name")
	private String fileName;

	/**
	 * String Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty("mime_type")
	private Integer mimeType;

	/**
	 * Integer Optional. File sizeInteger
	 */
	@JsonProperty("file_size")
	private Integer fileSize;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getMimeType() {
		return mimeType;
	}

	public void setMimeType(Integer mimeType) {
		this.mimeType = mimeType;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

}
