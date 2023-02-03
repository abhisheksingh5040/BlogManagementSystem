package com.te.blogmanagement.dto;

import java.util.ArrayList;
import java.util.List;

import com.te.blogmanagement.entity.BlogPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostDto {

	private String posttitle;
	private String postMetaTitle;
	private String postSlug;
	private String postSummary;
	private boolean postpublished;
	private String postContent;	
	private List<BlogPost> parentPost = new ArrayList<>();

	
}
