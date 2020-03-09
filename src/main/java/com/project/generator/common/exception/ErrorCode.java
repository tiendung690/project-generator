package com.project.generator.common.exception;

import java.text.MessageFormat;

public enum ErrorCode {

	FAILED(0, "FAILED"), SUCCESS(1, "SUCCESS"), SYSTEM_ERROR(500, ""),;

	private int code;
	private String message;

	ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String parse(Object... args) {
		return MessageFormat.format(message, args);
	}

}
