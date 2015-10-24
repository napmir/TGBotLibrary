package com.tgbotlibrary.response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TGResponse<T> {
	/**
	 * The response contains a JSON object, which always has a Boolean field
	 * ‘ok’ and may have an optional String field ‘description’ with a
	 * human-readable description of the result. If ‘ok’ equals true, the
	 * request was successful and the result of the query can be found in the
	 * ‘result’ field. In case of an unsuccessful request, ‘ok’ equals false and
	 * the error is explained in the ‘description’. An Integer ‘error_code’
	 * field is also returned, but its contents are subject to change in the
	 * future.
	 */
	
	@JsonProperty("ok")
	private Boolean ok;

	@JsonProperty("description")
	private String description;

	@JsonProperty("error_code")
	private Integer errorCode;
	
	@JsonProperty("result")
	private List<T> result;

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	
}
