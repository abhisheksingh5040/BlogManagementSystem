package com.te.blogmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blogmanagement.entity.BlogCategory;
import com.te.blogmanagement.entity.BlogPost;
import com.te.blogmanagement.entity.BlogTag;
import com.te.blogmanagement.entity.BlogUser;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {

//	List<BlogPost> findByBlogUserId(BlogUser blogUser);
//	
//	List<BlogPost> findByBlogCategoryId(BlogCategory blogCategory);
//	
//	List<BlogPost> findByBlogTagId(BlogTag blogTag);
	
	List<BlogPost> findByBlogUser(Integer blogUser);
	
}
