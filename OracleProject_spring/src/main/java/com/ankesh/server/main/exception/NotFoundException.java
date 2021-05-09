package com.ankesh.server.main.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errormessage;
	public NotFoundException(String message) {
		super(message);
	}
}
