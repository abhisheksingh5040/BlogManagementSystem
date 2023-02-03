package com.te.blogmanagement.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="blog_user")
public class BlogUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_user_id")
	private Integer blogUserId;
	@Column(name="first_name",length = 50)
	private String userFirstName;
	@Column(name="middle_name",length = 50)
	private String userMiddleName;
	@Column(name="last_name",length = 50)
	private String userLastName;
	@Column(name="mobile",length = 10)
	private String userMobileNumber;
	@Column(name="email",length = 50)
	private String userEmail;
	@Column(name="password_hash",length = 50)
	private String userPassword;
    @Column(name="registered_at")
	private LocalDateTime userRegisteredAt;
    @Column(name="last_login")
	private LocalDateTime userLastLogin;
	@Column(name="intro",length =150 , nullable = false)
	private String userIntro;
	@Column(name="profile",length = 250, nullable = false)
	private String userProfile;
	
	//Blog post
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "blogUser")
	@JsonBackReference
	private List<BlogPost> blogPost;
	
}
