package com.tgbotlibrary.request;

import java.io.File;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.tgbotlibrary.enums.RequestTypeEnum;

public class TGRequest {

	private RequestTypeEnum requestType;
	private List<BasicNameValuePair> parameters;
	private File file;
	private String fileType;

	public TGRequest(RequestTypeEnum requestType, List<BasicNameValuePair> parameters) {
		this(requestType, parameters, null, null);
	}
	
	public TGRequest(RequestTypeEnum requestType, List<BasicNameValuePair> parameters, File file, String fileType) {
		super();
		this.requestType = requestType;
		this.parameters = parameters;
		this.file = file;
		this.fileType = fileType;
	}

	public RequestTypeEnum getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestTypeEnum requestType) {
		this.requestType = requestType;
	}

	public List<BasicNameValuePair> getParameters() {
		return parameters;
	}

	public void setParameters(List<BasicNameValuePair> parameters) {
		this.parameters = parameters;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
