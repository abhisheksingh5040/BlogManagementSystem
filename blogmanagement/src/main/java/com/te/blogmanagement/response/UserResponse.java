package com.te.blogmanagement.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserResponse {
  private boolean error;
  private int status;
  private String message;
  private Object userDetails;
}
