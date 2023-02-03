package com.te.blogmanagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.blogmanagement.response.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> toHandleUserNotFoundException(
			UserNotFoundException userNotFoundException) {
		String message = userNotFoundException.getMessage();
		ExceptionResponse response = new ExceptionResponse(message, false);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public ResponseEntity<ExceptionResponse> toHandlePostNotFoundException(
			PostNotFoundException postNotFoundException) {
		String message = postNotFoundException.getMessage();
		ExceptionResponse response = new ExceptionResponse(message, false);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TagNotFoundException.class)
	public ResponseEntity<ExceptionResponse> toHandleTagNotFoundException(
			TagNotFoundException tagNotFoundException) {
		String message = tagNotFoundException.getMessage();
		ExceptionResponse response = new ExceptionResponse(message, false);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ExceptionResponse> toHandleCategoryNotFoundException(
			CategoryNotFoundException categoryNotFoundException) {
		String message = categoryNotFoundException.getMessage();
		ExceptionResponse response = new ExceptionResponse(message, false);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidInput(MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> invalidInputErrors = new HashMap<>();
		methodArgumentNotValidException.getBindingResult().getFieldErrors()
				.forEach(errors -> invalidInputErrors.put(errors.getField(), errors.getDefaultMessage()));

		return invalidInputErrors;
	}

}
