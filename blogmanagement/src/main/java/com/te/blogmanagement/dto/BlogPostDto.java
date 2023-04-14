package com.te.blogmanagement.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.te.blogmanagement.entity.BlogPost;

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
public class BlogPostDto {

	private String posttitle;
	private String postMetaTitle;
	private String postSlug;
	private String postSummary;
	private boolean postpublished;
	private String postContent;	
	private List<BlogPost> parentPost = new ArrayList<>();

	
}
