package com.te.blogmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.blogmanagement.dto.BlogCategoryDto;
import com.te.blogmanagement.dto.BlogTagDto;
import com.te.blogmanagement.dto.BlogUserDto;
import com.te.blogmanagement.entity.BlogCategory;
import com.te.blogmanagement.entity.BlogTag;
import com.te.blogmanagement.response.CategoryResponse;
import com.te.blogmanagement.response.TagResponse;
import com.te.blogmanagement.response.UserResponse;
import com.te.blogmanagement.service.BlogAdminService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/admin")
public class BlogAdminController {

	@Autowired
	private BlogAdminService blogAdminService;
	
	@Autowired
	private UserResponse userResponse;
	
	@Autowired
	private TagResponse tagResponse;
	
	@Autowired
	private CategoryResponse categoryResponse;
	
	
	@Operation(summary = "get user by Id")
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<BlogUserDto> readUserById(@PathVariable Integer userId) {
		BlogUserDto blogUserDto = blogAdminService.readUserById(userId);
		if (blogUserDto != null) {
			return new ResponseEntity<BlogUserDto>(blogUserDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogUserDto>(HttpStatus.BAD_REQUEST);
		}
	}
		
	@Operation(summary = "delete user by Id")
	@DeleteMapping("/deleteUserById/{userId}")
	public ResponseEntity<UserResponse> deleteUserById(@PathVariable Integer userId) {
		boolean flag = blogAdminService.deleteUserById(userId);
		if (flag) {
			userResponse.setError(false);
			userResponse.setMessage("User deleted successfully...");
			userResponse.setStatus(200);
			return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
		} else {
			userResponse.setMessage("User not found...");
			return new ResponseEntity<UserResponse>(userResponse, HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary= "create a new tag")
	@PostMapping("/createTag")
	public ResponseEntity<TagResponse> createTags(@Valid @RequestBody BlogTagDto blogTagDto) {
		BlogTag blogTag = blogAdminService.createTags(blogTagDto);
		if (blogTag != null) {
			tagResponse.setError(false);
			tagResponse.setMessage("tag created succesfully...");
			tagResponse.setStatus(201);
			tagResponse.setTags(blogTag);
			return new ResponseEntity<TagResponse>(tagResponse, HttpStatus.CREATED);
		} else {
			tagResponse.setError(true);
			tagResponse.setStatus(402);
			return new ResponseEntity<TagResponse>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary="update tag by using Id")
	@PutMapping("/updateTagById/{tagId}")
	public ResponseEntity<TagResponse> updateTagById(@Valid @RequestBody BlogTagDto blogTagDto,
			@PathVariable Integer tagId) {
		BlogTag blogTag = blogAdminService.updatetagById(blogTagDto, tagId);
		if (blogTag != null) {
			tagResponse.setError(false);
			tagResponse.setMessage(" Tags updated successfully...");
			tagResponse.setStatus(201);
			tagResponse.setTags(blogTagDto);
			return new ResponseEntity<TagResponse>(tagResponse, HttpStatus.CREATED);
		} else {
			tagResponse.setError(true);
			tagResponse.setStatus(402);
			return new ResponseEntity<TagResponse>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "create category")
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryResponse> createCategories(@Valid @RequestBody BlogCategoryDto blogCategoryDto) {
		BlogCategory blogCategory = blogAdminService.createCategory(blogCategoryDto);
		if (blogCategory != null) {
			categoryResponse.setError(false);
			categoryResponse.setMessage(" categories created successfully...");
			categoryResponse.setStatus(201);
			categoryResponse.setCategories(blogCategory);
			return new ResponseEntity<CategoryResponse>(categoryResponse, HttpStatus.CREATED);
		} else {
			categoryResponse.setError(true);
			categoryResponse.setStatus(402);
			return new ResponseEntity<CategoryResponse>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary="update a category by Id")
	@PutMapping("/updateCategoryById/{categoryId}")
	public ResponseEntity<CategoryResponse> updateCategoryById(@Valid @RequestBody BlogCategoryDto blogCategoryDto,
			@PathVariable Integer categoryId) {
		BlogCategory blogCategory = blogAdminService.updateCategoryById(blogCategoryDto, categoryId);
		if (blogCategory != null) {
			categoryResponse.setError(false);
			categoryResponse.setMessage(" categories updated successfully...");
			categoryResponse.setStatus(201);
			categoryResponse.setCategories(blogCategoryDto);
			return new ResponseEntity<CategoryResponse>(categoryResponse, HttpStatus.CREATED);
		} else {
			categoryResponse.setError(true);
			categoryResponse.setStatus(402);
			return new ResponseEntity<CategoryResponse>(HttpStatus.BAD_REQUEST);
		}
	}

}
