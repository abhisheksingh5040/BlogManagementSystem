package com.te.blogmanagement.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.blogmanagement.dto.BlogCategoryDto;
import com.te.blogmanagement.dto.BlogTagDto;
import com.te.blogmanagement.dto.BlogUserDto;
import com.te.blogmanagement.entity.BlogCategory;
import com.te.blogmanagement.entity.BlogTag;
import com.te.blogmanagement.entity.BlogUser;
import com.te.blogmanagement.exception.BlogManagementMasterException;
import com.te.blogmanagement.exception.CategoryNotFoundException;
import com.te.blogmanagement.exception.TagNotFoundException;
import com.te.blogmanagement.exception.UserNotFoundException;
import com.te.blogmanagement.repository.BlogCategoryRepository;
import com.te.blogmanagement.repository.BlogTagRepository;
import com.te.blogmanagement.repository.BlogUserRepository;
import com.te.blogmanagement.service.BlogAdminService;

@Service
public class BlogAdminServiceImpl implements BlogAdminService {

	@Autowired
	private BlogUserRepository blogUserRepository;
	
	@Autowired
	private BlogCategoryRepository blogCategoryRepository;
	
	@Autowired
	private BlogTagRepository blogTagRepository;
	
	@Override
	public BlogUserDto readUserById(Integer userId) {
		BlogUser user = blogUserRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(BlogManagementMasterException.USER_ID_NOT_FOUND));
		BlogUserDto blogUserDto = new BlogUserDto();
		BeanUtils.copyProperties(user, blogUserDto);
		return blogUserDto;
	}

	// delete
	@Override
	public boolean deleteUserById(Integer userId) {
		BlogUser user = blogUserRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(BlogManagementMasterException.USER_ID_NOT_FOUND));

		if (user != null) {
			blogUserRepository.deleteById(userId);
			return true;
		} else {
			return false;
		}
	}

	//create category
	
	@Override
	public BlogCategory createCategory(BlogCategoryDto blogCategoryDto) {
		BlogCategory blogCategory = new BlogCategory();
		BeanUtils.copyProperties(blogCategoryDto, blogCategory);

		return blogCategoryRepository.save(blogCategory);
	}

	// update category by Id
	@Override
	public BlogCategory updateCategoryById(BlogCategoryDto blogCategoryDto, Integer categoryId) {
		BlogCategory updateCategory = blogCategoryRepository.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException(BlogManagementMasterException.CATEGORY_ID_NOT_FOUND));

		updateCategory.setCategoryContent(blogCategoryDto.getCategoryContent());
		updateCategory.setCategoryMetaTitle(blogCategoryDto.getCategoryMetaTitle());
		updateCategory.setCategorySlug(blogCategoryDto.getCategorySlug());
		updateCategory.setCategoryTitle(blogCategoryDto.getCategoryTitle());
		return blogCategoryRepository.save(updateCategory);
	}
	
	@Override
	public BlogTag createTags(BlogTagDto blogTagDto) {
		BlogTag blogTag = new BlogTag();
		BeanUtils.copyProperties(blogTagDto, blogTag);
		return blogTagRepository.save(blogTag);
	}
	
	@Override
	public BlogTag updatetagById(BlogTagDto blogTagDto, Integer tagId) {
		BlogTag updateBlogTag = blogTagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException(BlogManagementMasterException.TAG_ID_NOT_FOUND));
		updateBlogTag.setTagContent(blogTagDto.getTagContent());
		updateBlogTag.setTagMetaTitle(blogTagDto.getTagMetaTitle());
		updateBlogTag.setTagSlug(blogTagDto.getTagSlug());
		updateBlogTag.setTagContent(blogTagDto.getTagContent());
		return blogTagRepository.save(updateBlogTag);
	}

}
