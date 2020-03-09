package com.project.generator.common.rest;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.generator.common.exception.ApplicationException;
import com.project.generator.common.exception.ErrorCode;

public class RestResponse<T> implements Serializable {

	private static final long serialVersionUID = -4150800751579236573L;
	private int code;
	private boolean success;
	private String message;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp = new Date();
	private T data;
	private String path;

	public RestResponse() {
	}

	public void success(String message) {
		success(message, null);
	}

	public RestResponse<T> success(T data) {
		this.message = ErrorCode.SUCCESS.getMessage();
		return success(ErrorCode.SUCCESS.getMessage(), data);
	}

	public RestResponse<T> success(String message, T data) {
		this.success = true;
		this.code = ErrorCode.SUCCESS.getCode();
		this.message = message;
		this.data = data;
		return this;
	}

	public RestResponse<T> failed(ErrorCode errorCode, Object... values) {
		return failed(new ApplicationException(errorCode, values));
	}

	public RestResponse<T> failed(Exception e) {
		this.success = false;
		if (e instanceof ApplicationException) {
			this.code = ((ApplicationException) e).getCode();
			this.message = e.getMessage();
		} else {
			this.code = (ErrorCode.SYSTEM_ERROR.getCode());
			this.message = ErrorCode.SYSTEM_ERROR.getMessage();
		}
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
