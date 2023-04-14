package com.te.blogmanagement.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
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
public class BlogCategoryDto {
	
	private Integer categoryId;
	@NotBlank(message = "title cannot be empty")
	private String categoryTitle;
	private String categoryMetaTitle;
	private String categorySlug;
	@NotBlank
	private String categoryContent;
}
