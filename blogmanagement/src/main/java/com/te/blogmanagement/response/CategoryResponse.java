package com.te.blogmanagement.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CategoryResponse {
	  private boolean error;
	  private int status;
	  private String message;
	  private Object categories;
}
