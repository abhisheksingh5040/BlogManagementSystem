package com.te.blogmanagement.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.blogmanagement.dto.BlogPostDto;
import com.te.blogmanagement.dto.BlogPostMetaDto;
import com.te.blogmanagement.dto.BlogPostViewDto;
import com.te.blogmanagement.dto.BlogUserDto;
import com.te.blogmanagement.entity.BlogCategory;
import com.te.blogmanagement.entity.BlogPost;
import com.te.blogmanagement.entity.BlogPostMeta;
import com.te.blogmanagement.entity.BlogTag;
import com.te.blogmanagement.entity.BlogUser;
import com.te.blogmanagement.exception.BlogManagementMasterException;
import com.te.blogmanagement.exception.PostNotFoundException;
import com.te.blogmanagement.exception.UserNotFoundException;
import com.te.blogmanagement.repository.BlogCategoryRepository;
import com.te.blogmanagement.repository.BlogPostMetaRepository;
import com.te.blogmanagement.repository.BlogPostRepository;
import com.te.blogmanagement.repository.BlogTagRepository;
import com.te.blogmanagement.repository.BlogUserRepository;
import com.te.blogmanagement.service.BlogUsersService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BlogUsersServiceImpl implements BlogUsersService {

	private final BlogUserRepository blogUserRepository;
	private final BlogPostRepository blogPostRepository;
	private final BlogPostMetaRepository blogPostMetaRepository;
	private final BlogCategoryRepository blogCategoryRepository;
	private final BlogTagRepository blogTagRepository;

	@Override
	public BlogUserDto registerNewUser(BlogUserDto blogUserDto) {
		BlogUser blogUser = new BlogUser();
		BeanUtils.copyProperties(blogUserDto, blogUser);
		blogUser.setUserRegisteredAt(LocalDateTime.now());
		blogUserRepository.save(blogUser);
		BeanUtils.copyProperties(blogUser, blogUserDto);
		return blogUserDto;
	}

	// update user by its Id
	@Override
	public BlogUser UpdateUserById(BlogUserDto blogUserDto, Integer userId) {
		BlogUser blogUser = blogUserRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(BlogManagementMasterException.USER_ID_NOT_FOUND));

		BeanUtils.copyProperties(blogUserDto, blogUser);
		blogUser.setBlogUserId(userId);
		BeanUtils.copyProperties(blogUser, blogUserDto);
		return blogUserRepository.save(blogUser);
	}


	// add meta deta
	@Override
	public BlogPostMetaDto addPostMeta(Integer postId, BlogPostMetaDto blogPostMetaDto) {
		BlogPost blogPost = blogPostRepository.findById(postId)
				.orElseThrow(() -> new PostNotFoundException(BlogManagementMasterException.POST_ID_NOT_FOUND));
		BlogPostMeta blogPostMeta = new BlogPostMeta();
		//BeanUtils.copyProperties(blogPostMetaDto, blogPostMeta);
		//blogPostMeta.setBlogPost(blogPost);
		//blogPostMetaRepository.save(blogPostMeta);
		BeanUtils.copyProperties(blogPostMeta, blogPostMetaDto);
		return blogPostMetaDto;
	}

	@Override
	public BlogPostViewDto createNewPosts(Integer userId, BlogPostDto blogPostDto, List<Integer> tagId,
			List<Integer> categoryId) {
		BlogUser blogUser = blogUserRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(BlogManagementMasterException.USER_ID_NOT_FOUND));
		BlogPostViewDto blogPostViewDto = new BlogPostViewDto();
		BlogPost blogPost = new BlogPost();
		BeanUtils.copyProperties(blogPostDto, blogPost);
		List<BlogCategory> blogCategories = blogCategoryRepository.findAllById(categoryId);
		List<BlogTag> blogTags = blogTagRepository.findAllById(tagId);
		blogPost.setBlogCategory(blogCategories);
		blogPost.setBlogTag(blogTags);
		blogPost.setBlogUser(blogUser);
		blogPost.setPostCreatedAt(LocalDateTime.now());
		blogPost.setPostUpdatedAt(LocalDateTime.now());
		blogPost.setPostPublishedAt(LocalDateTime.now());
		BeanUtils.copyProperties(blogPost, blogPostViewDto);
		blogPostRepository.save(blogPost);
		return blogPostViewDto;
	}

}
