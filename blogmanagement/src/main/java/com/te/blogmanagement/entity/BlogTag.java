package com.te.blogmanagement.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
@Table(name="blog_tag")
public class BlogTag implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tag_id")
	private Integer tagId;
	@Column(name="title",length = 100)
	private String tagTitle;
	@Column(name="meta_title",length = 500)
	private String tagMetaTitle;
	@Column(name="slug",length = 50)
	private String tagSlug;
	@Column(name="content",length = 50)
	private String tagContent;
	
	//blog post
	@ManyToMany(mappedBy="blogTag",cascade = CascadeType.ALL)
	@JsonBackReference
	private List<BlogPost> blogPost;

}
