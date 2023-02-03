package com.te.blogmanagement.dto;

import java.util.List;

import com.te.blogmanagement.entity.BlogPost;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogCategoryViewDto {

	private Integer categoryId;
	private String categoryTitle;
	private String categoryMetaTitle;
	private String categorySlug;
	private String categoryContent;
	private List<BlogPostViewDto> blogPostViewDtos;
}
