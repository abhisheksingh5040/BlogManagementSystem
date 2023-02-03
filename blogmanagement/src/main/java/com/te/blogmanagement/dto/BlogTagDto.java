package com.te.blogmanagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogTagDto {

	private Integer tagId;
	private String tagTitle;
	private String tagMetaTitle;
	private String tagSlug;
	private String tagContent;
	private List<BlogPostViewDto> blogPostViewDtos;
}
