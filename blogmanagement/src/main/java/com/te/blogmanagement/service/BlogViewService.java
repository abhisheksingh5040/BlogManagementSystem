package com.te.blogmanagement.service;

import java.util.List;

import com.te.blogmanagement.dto.BlogCategoryDto;
import com.te.blogmanagement.dto.BlogCategoryViewDto;
import com.te.blogmanagement.dto.BlogPostCommentDto;
import com.te.blogmanagement.dto.BlogPostViewByIdDto;
import com.te.blogmanagement.dto.BlogPostViewDto;
import com.te.blogmanagement.dto.BlogTagDto;
import com.te.blogmanagement.dto.BlogTagViewDto;
import com.te.blogmanagement.entity.BlogPostComment;

public interface BlogViewService {

	List<BlogPostViewDto> getAllPosts();

	BlogPostViewByIdDto getPostById(Integer postId);
	
	BlogTagViewDto getTagById(Integer tagId);

	List<BlogTagDto> getAllTags();
	
	BlogCategoryViewDto getCategoryById(Integer categoryId);

	List<BlogCategoryDto> getAllCategories();
	
	BlogPostComment addCommentToPost(BlogPostCommentDto blogPostCommentDto, Integer postId);
}
