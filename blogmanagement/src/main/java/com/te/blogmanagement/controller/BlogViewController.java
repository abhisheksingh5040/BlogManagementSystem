package com.te.blogmanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.blogmanagement.dto.BlogCategoryDto;
import com.te.blogmanagement.dto.BlogCategoryViewDto;
import com.te.blogmanagement.dto.BlogPostCommentDto;
import com.te.blogmanagement.dto.BlogPostViewByIdDto;
import com.te.blogmanagement.dto.BlogPostViewDto;
import com.te.blogmanagement.dto.BlogTagDto;
import com.te.blogmanagement.dto.BlogTagViewDto;
import com.te.blogmanagement.entity.BlogPostComment;
import com.te.blogmanagement.service.BlogViewService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/view")
public class BlogViewController {
	
	private final BlogViewService blogViewService;
	
	@Operation(summary = "get all the post")
	@GetMapping("/posts")
	public ResponseEntity<List<BlogPostViewDto>> getAllPosts() {
		return ResponseEntity.ok(blogViewService.getAllPosts());
	}

	@Operation(summary = "get post by Id")
	@GetMapping("/post/{postId}")
	public ResponseEntity<BlogPostViewByIdDto> getPostById(@PathVariable Integer postId) {
			return ResponseEntity.ok(blogViewService.getPostById(postId));
	}
	
	@Operation(summary= "To get all the tag")
	@GetMapping("/tags")
	public ResponseEntity<List<BlogTagDto>> getAllTags() {
		return ResponseEntity.ok(blogViewService.getAllTags());
	}
	
	@Operation(summary="To get tag by using an Id")
	@GetMapping("/tag/{tagId}")
	public ResponseEntity<BlogTagViewDto> getTagById(@PathVariable Integer tagId) {
		return ResponseEntity.ok(blogViewService.getTagById(tagId));
	}
	
	@Operation(summary="get a category by Id")
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<BlogCategoryViewDto> readCategoryById(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(blogViewService.getCategoryById(categoryId));
	}

    @Operation(summary="To get all the categories")
	@GetMapping("/categories")
	public ResponseEntity<List<BlogCategoryDto>> getAllCategories() {
		return ResponseEntity.ok(blogViewService.getAllCategories());
	}
    
    @Operation(summary="add a comment by using user id")
    @PostMapping("addCommentToPost/{postId}")
	public ResponseEntity<BlogPostComment> addCommentToPost(@RequestBody BlogPostCommentDto blogPostCommentDto,
			@PathVariable Integer postId) {
		return ResponseEntity.ok(blogViewService.addCommentToPost(blogPostCommentDto, postId));
	}
}
