package com.te.blogmanagement.response;

import org.springframework.stereotype.Component;

import com.te.blogmanagement.dto.BlogCategoryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Component
public class ExceptionResponse {

	private String message;
	private boolean error;
}
