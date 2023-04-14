package com.te.blogmanagement.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.te.blogmanagement.dto.BlogPostDto;
import com.te.blogmanagement.dto.BlogUserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="blog_category")
public class BlogCategory implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	@Column(name="title",length = 100)
	private String categoryTitle;
	@Column(name="meta_title",length = 100)
	private String categoryMetaTitle;
	@Column(name="slug",length = 50)
	private String categorySlug;
	@Column(name="content",length = 250)
	private String categoryContent;
	
	@ManyToMany(mappedBy="blogCategory",cascade = CascadeType.ALL)
	@JsonBackReference
	private List<BlogPost> blogPosts;

}
