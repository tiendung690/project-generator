package com.project.generator.common.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 5159583551130008434L;
	private int code;

	public ApplicationException() {
	}

	public ApplicationException(ErrorCode code, Object... args) {
		this(code, null, args);
	}

	public ApplicationException(ErrorCode code, Exception ex, Object... args) {
		super(code.parse(args), ex);
		this.code = code.getCode();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
