package com.te.blogmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blogmanagement.entity.BlogPostComment;

@Repository
public interface BlogPostCommentRepository extends JpaRepository<BlogPostComment, Integer> {

}
