package com.te.blogmanagement.service;

import com.te.blogmanagement.dto.BlogCategoryDto;
import com.te.blogmanagement.dto.BlogTagDto;
import com.te.blogmanagement.dto.BlogUserDto;
import com.te.blogmanagement.entity.BlogCategory;
import com.te.blogmanagement.entity.BlogTag;

public interface BlogAdminService {

	// get user by Id
	BlogUserDto readUserById(Integer blogUserId);

	// delete user by Id
	boolean deleteUserById(Integer userId);

	// Create Category
	BlogCategory createCategory(BlogCategoryDto blogCategoryDto);

	// update Category
	BlogCategory updateCategoryById(BlogCategoryDto blogCategoryDto, Integer categoryId);

	// Create Tags
	BlogTag createTags(BlogTagDto blogTagDto);

	// update tag by Id
	BlogTag updatetagById(BlogTagDto blogTagDto, Integer tagId);
}
