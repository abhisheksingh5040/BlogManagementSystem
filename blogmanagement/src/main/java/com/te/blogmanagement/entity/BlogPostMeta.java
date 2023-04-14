package com.te.blogmanagement.entity;


import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.te.blogmanagement.dto.BlogPostDto;
import com.te.blogmanagement.dto.BlogUserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="blog_post_meta")
public class BlogPostMeta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_meta_id")
	private Integer BlogPostMetaId;
	private String postMetaKey;
	private String postMetaContent;
	
	// blog post
	@ManyToOne
	private BlogPost blogPost;

}
