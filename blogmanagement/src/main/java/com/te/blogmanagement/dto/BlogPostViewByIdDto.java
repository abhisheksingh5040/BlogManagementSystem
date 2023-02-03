package com.te.blogmanagement.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.te.blogmanagement.entity.BlogCategory;
import com.te.blogmanagement.entity.BlogPostComment;
import com.te.blogmanagement.entity.BlogTag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostViewByIdDto {

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
	private List<BlogPostComment> blogPostComment;
	private List<BlogCategory> blogCategory;
	private List<BlogTag> blogTag;
}
