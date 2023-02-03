package com.te.blogmanagement.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.te.blogmanagement.entity.BlogPostComment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostViewDto {
	
	private Integer postId;
	private String posttitle;
	private String postMetaTitle;
	private String postSlug;
	private String postSummary;
	private boolean postpublished;
	private LocalDateTime postCreatedAt;
	private LocalDateTime postUpdatedAt;
	private LocalDateTime postPublishedAt;
	private String postContent;

}
