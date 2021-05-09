package com.ankesh.server.main.exception;

import java.util.Date;

public class ExceptionResponse {
	Date date;
	String message;
	String desc;
	public ExceptionResponse(Date date, String message, String desc){
		super();
		this.date = date;
		this.message = message;
		this.desc = desc;
	}
	
}
