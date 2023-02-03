package com.te.blogmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blogmanagement.entity.BlogTag;

@Repository
public interface BlogTagRepository extends JpaRepository<BlogTag, Integer> {

}
