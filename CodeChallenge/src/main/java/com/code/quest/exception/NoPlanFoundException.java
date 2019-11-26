package com.code.quest.exception;

public class NoPlanFoundException extends Exception {
	private String message;

	public NoPlanFoundException(String message) {
		super();
		this.message = message;
	}

}
