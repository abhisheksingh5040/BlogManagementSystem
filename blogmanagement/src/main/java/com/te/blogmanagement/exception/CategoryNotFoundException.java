package com.te.blogmanagement.exception;

public class CategoryNotFoundException extends RuntimeException{

	public CategoryNotFoundException(String message) {
		super(message);
	}
}
