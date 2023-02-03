package com.te.blogmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blogmanagement.entity.BlogUser;

@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser, Integer> {


}
