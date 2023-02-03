package com.te.blogmanagement.exception;

public class TagNotFoundException extends RuntimeException{

	public TagNotFoundException(String message) {
		super(message);
	}
}
