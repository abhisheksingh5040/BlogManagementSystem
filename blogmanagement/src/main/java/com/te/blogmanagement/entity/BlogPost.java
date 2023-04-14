package com.te.blogmanagement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.te.blogmanagement.dto.BlogPostDto;
import com.te.blogmanagement.dto.BlogUserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "blog_post")
public class BlogPost implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_id")
	private Integer postId;
	@Column(name="title",length = 250)
	private String posttitle;
	@Column(name="meta_title",length = 250)
	private String postMetaTitle;
	@Column(name="slug",length = 250)
	private String postSlug;
	@Column(name="summary",length = 500)
	private String postSummary;
    @Column(name="published")
	private boolean postpublished;
    @Column(name="created_at")
	private LocalDateTime postCreatedAt;
    @Column(name="updated_at")
	private LocalDateTime postUpdatedAt;
    @Column(name="published_at")
	private LocalDateTime postPublishedAt;
    @Column(name="content")
	private String postContent;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="parent_id")
	private List<BlogPost> parentPost = new ArrayList<BlogPost>();

	// User
	@ManyToOne
	@JoinColumn(name="author_id")
	@JsonBackReference
	private BlogUser blogUser;
	
	//Post Meta
	@OneToMany(mappedBy="blogPost",cascade = CascadeType.ALL)
	private List<BlogPostMeta> blogPostMeta;
	
	//Post Comment
	@OneToMany(mappedBy="blogPost",cascade = CascadeType.ALL)
	private List<BlogPostComment> blogPostComment; 
	
	//Tags
	@ManyToMany(cascade = CascadeType.ALL)
	private List<BlogTag> blogTag;
	
    //Categories
	@ManyToMany(cascade = CascadeType.ALL)
	private List<BlogCategory> blogCategory;

}
