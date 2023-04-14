package com.te.blogmanagement.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.te.blogmanagement.entity.BlogPost;

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
public class BlogCategoryViewDto {

	private Integer categoryId;
	private String categoryTitle;
	private String categoryMetaTitle;
	private String categorySlug;
	private String categoryContent;
	private List<BlogPostViewDto> blogPostViewDtos;
}
