package com.te.blogmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.blogmanagement.entity.BlogPostMeta;

public interface BlogPostMetaRepository extends JpaRepository<BlogPostMeta,Integer>{

}
