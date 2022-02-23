package com.beta.replyservice.service.exception;

public class ReplyServiveException {

	private int code;
	private String message;

	public ReplyServiveException(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
