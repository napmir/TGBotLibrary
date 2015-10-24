package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class File implements Response{

	/**
	 * String Unique identifier for this file
	 */
	@JsonProperty("file_id")
	private String id;

	/**
	 * Integer Optional. File size, if known
	 */
	@JsonProperty("file_size")
	private Integer fileSize;

	/**
	 * String Optional. File path. Use https://api.telegram.org/file/bot<token>/
	 * <file_path> to get the file.
	 */
	@JsonProperty("file_path")
	private Integer filePath;

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

	public Integer getFilePath() {
		return filePath;
	}

	public void setFilePath(Integer filePath) {
		this.filePath = filePath;
	}

}
