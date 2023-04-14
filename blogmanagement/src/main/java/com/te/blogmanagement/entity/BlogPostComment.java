package com.te.blogmanagement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.te.blogmanagement.dto.BlogPostDto;
import com.te.blogmanagement.dto.BlogUserDto;

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
@Table(name="blog_post_comment")
public class BlogPostComment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_comment_id")
	private Integer postCommentId;
	@Column(name="title",length = 150)
	private String postCommentTitle;
	@Column(name="published")
	private boolean postCommentPublished;
    @Column(name="published_at")
	private LocalDateTime postCommentPublishedAt;
    @Column(name="created_at")
	private LocalDateTime postCommentCreatedAt;
    @Column(name="content",length = 500)												
	private String postCommentContent;

	// Post
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="post_id")
	private BlogPost blogPost;

}
