package com.te.blogmanagement.controller;

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
import com.te.blogmanagement.response.Response;
import com.te.blogmanagement.service.BlogAdminService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/admin")
public class BlogAdminController {

	private final BlogAdminService blogAdminService;
	private final Response response;

	@Operation(summary = "get user by Id")
	@GetMapping("/user/{userId}")
	public ResponseEntity<BlogUserDto> readUserById(@PathVariable Integer userId) {
		return ResponseEntity.ok(blogAdminService.readUserById(userId));
	}

	@Operation(summary = "delete user by Id")
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<Response> deleteUserById(@PathVariable Integer userId) {
   System.out.print("Hi bro");		
   System.out.print("Hi bro");		
   System.out.print("Hi bro");		
		return ResponseEntity.ok(Response.builder()
						.error(false)
						.status(200)
						.data(blogAdminService.deleteUserById(userId))
						.message("User Deleted Successfully...")
						.build());
	}

	@Operation(summary = "create a new tag")
	@PostMapping("/tag")
	public ResponseEntity<Response> createTags(@Valid @RequestBody BlogTagDto blogTagDto) {
			
		return new ResponseEntity<Response>(Response.builder()
					.error(false)
					.message("tag created successfully")
					.data(blogAdminService.createTags(blogTagDto))
					.build(), HttpStatus.CREATED);
	}

	@Operation(summary = "update tag by using Id")
	@PutMapping("/tag/{tagId}")
	public ResponseEntity<Response> updateTagById(@Valid @RequestBody BlogTagDto blogTagDto,
			@PathVariable Integer tagId) {
		
		return ResponseEntity.ok(Response.builder()
				.error(false)
				.status(200)
				.data(blogAdminService.updatetagById(blogTagDto, tagId))
				.message("Tags updated successfully...")
				.build());
	}

	@Operation(summary = "create category")
	@PostMapping("/category")
	public ResponseEntity<Response> createCategories(@Valid @RequestBody BlogCategoryDto blogCategoryDto) {
		
		return new ResponseEntity<>(Response.builder()
				.error(false)
				.status(200)
				.data(blogAdminService.createCategory(blogCategoryDto))
				.message("Categories created successfully...")
				.build(),HttpStatus.CREATED);
	}

	@Operation(summary = "update a category by Id")
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<Response> updateCategoryById(@Valid @RequestBody BlogCategoryDto blogCategoryDto,
			@PathVariable Integer categoryId) {
		
		return ResponseEntity.ok(Response.builder()
				.error(false)
				.status(200)
				.data(blogAdminService.createCategory(blogCategoryDto))
				.message("Category updated successfully...")
				.build());
		
	}

}
