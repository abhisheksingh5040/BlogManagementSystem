package com.te.blogmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.blogmanagement.dto.BlogPostDto;
import com.te.blogmanagement.dto.BlogPostMetaDto;
import com.te.blogmanagement.dto.BlogPostViewDto;
import com.te.blogmanagement.dto.BlogUserDto;
import com.te.blogmanagement.entity.BlogUser;
import com.te.blogmanagement.response.Response;
import com.te.blogmanagement.service.BlogUsersService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class BlogUserController {

	private final BlogUsersService blogUsersService;

	@Operation(summary = "registration of new user.")
	@PostMapping("/registerUser")
	public ResponseEntity<Response> registerNewUser(@Valid @RequestBody BlogUserDto blogUserDto) {

		return new ResponseEntity<Response>(Response.builder().error(false).message("User Added successfully...")
				.data(blogUsersService.registerNewUser(blogUserDto)).build(), HttpStatus.CREATED);

	}

	@Operation(summary = "update a user by its id")
	@PutMapping("/updateUserById/{userId}")
	public ResponseEntity<Response> updateUserById(@Valid @RequestBody BlogUserDto blogUserDto,
			@PathVariable Integer userId) {

		return ResponseEntity.ok(
				Response.builder().error(false).status(200).data(blogUsersService.UpdateUserById(blogUserDto, userId))
						.message("User updated successfully...").build());
	}

	@Operation(summary = "create a post by using multiple category id and multiple tag id")
	@PostMapping("/createPosts/userId/{userId}/catgegoryId/{categoryId}/tagId/{tagId}")
	public ResponseEntity<Response> createNewPost(@RequestBody BlogPostDto blogPostDto, @PathVariable Integer userId,
			@PathVariable List<Integer> categoryId, @PathVariable List<Integer> tagId) {

		return new ResponseEntity<Response>(
				Response.builder().error(false).message("post added successfully...")
						.data(blogUsersService.createNewPosts(userId, blogPostDto, tagId, categoryId)).build(),
				HttpStatus.CREATED);
	}

	@PostMapping("/addpostmeta/{postId}")
	public ResponseEntity<Response> addPostMeta(@PathVariable Integer postId,
			@RequestBody BlogPostMetaDto blogPostMetaDto) {

		return new ResponseEntity<Response>(Response.builder().error(false).message("meta data added succesfully.....")
				.data(blogUsersService.addPostMeta(postId, blogPostMetaDto)).build(), HttpStatus.CREATED);

	}
}
