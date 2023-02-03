package com.te.blogmanagement.entity;


import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BlogPostMeta {
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
