package com.te.blogmanagement.dto;

import java.util.List;

import org.springframework.stereotype.Component;

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
public class BlogTagDto {

	private Integer tagId;
	private String tagTitle;
	private String tagMetaTitle;
	private String tagSlug;
	private String tagContent;
	private List<BlogPostViewDto> blogPostViewDtos;
}
