package com.te.blogmanagement.dto;


import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserDto {

	//private Integer blogUserId;
	@NotBlank(message = "First name cannot be empty")
	private String userFirstName;
	@NotBlank(message = "Middle name cannot be empty")
	private String userMiddleName;
	@NotBlank(message = "Last name cannot be empty")
	private String userLastName;
	@NotBlank
	@Pattern(regexp = "[6789][0-9]{9}",message="mobile number should have 10 digits ")
	private String userMobileNumber;
	@NotBlank(message = "It is mandatory to fill Email Id")
	@Email(message="format of email id should be abc@gmail.com")
	private String userEmail;	
	@NotBlank
	private String userPassword;
	@NotBlank
	private String userIntro;
	@NotBlank
	private String userProfile;
	private List<BlogPostDto> blogPost;

}
