package com.lgcns.laf.exception;

public class LException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LException() {
		super();
	}

	public LException(String message) {
		super(message);
	}

	public LException(String message, Throwable cause) {
		super(message, cause);
	}

	public LException(Throwable cause) {
		super(cause);
	}
}
