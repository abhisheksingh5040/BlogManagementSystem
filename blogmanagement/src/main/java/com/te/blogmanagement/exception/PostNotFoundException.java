package com.te.blogmanagement.exception;

public class PostNotFoundException extends RuntimeException{

	public PostNotFoundException (String message) {
		super(message);
	}
}
