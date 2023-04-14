package com.te.blogmanagement.dto;

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
public class BlogPostCommentDto {
	//private Integer postCommentId;
	//private Integer postId;
	private String postCommentTitle;
	private boolean postCommentPublished;
	private String postCommentContent;
	//private BlogPost blogPost;
}
