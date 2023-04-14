package com.te.blogmanagement.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.te.blogmanagement.entity.BlogPostComment;

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
