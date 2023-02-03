package com.te.blogmanagement.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostMetaDto {

	private String postMetaKey;
	private String postMetaContent;
}
