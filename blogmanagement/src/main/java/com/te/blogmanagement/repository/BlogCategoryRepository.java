package com.te.blogmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blogmanagement.entity.BlogCategory;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Integer> {

}
