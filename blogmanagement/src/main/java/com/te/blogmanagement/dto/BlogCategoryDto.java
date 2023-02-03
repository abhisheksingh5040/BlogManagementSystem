package com.te.blogmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogCategoryDto {
	
	private Integer categoryId;
	@NotBlank(message = "title cannot be empty")
	private String categoryTitle;
	private String categoryMetaTitle;
	private String categorySlug;
	@NotBlank
	private String categoryContent;
}
