package com.multiplex.exception;

public class ShowNotFoundException extends RuntimeException{
	public ShowNotFoundException (String message) {
		super(message);
	}
	public ShowNotFoundException() {
		
	}
}
