package com.te.blogmanagement.dto;

import com.te.blogmanagement.entity.BlogPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostCommentDto {
	//private Integer postCommentId;
	//private Integer postId;
	private String postCommentTitle;
	private boolean postCommentPublished;
	private String postCommentContent;
	//private BlogPost blogPost;
}
