package com.id.danafix.codingtest.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ResponseModel<T> {

	private String timestamp;
	private String success;
	private Integer statusCode;
	private String message;
	private Object data;
	
	public ResponseModel() {
		this.message = "Your request has been processed successfully";
		this.statusCode = HttpStatus.OK.value();
		this.success = "true";
		this.timestamp=String.valueOf(new Date().getTime());
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
