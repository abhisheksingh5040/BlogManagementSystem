package com.te.blogmanagement.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
public class ExceptionResponse {

	private String message;
	private boolean error;
}
