package com.smokies.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BLOG")
public class Blog {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "blog_title")
	private String blogTitle;

	@Column(name = "blog_post")
	private String blogPost;

	public Blog(String blogTitle, String blogPost) {
		this.blogTitle = blogTitle;
		this.blogPost = blogPost;
	}

	public Blog() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogPost() {
		return blogPost;
	}

	public void setBlogPost(String blogPost) {
		this.blogPost = blogPost;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", blogTitle=" + blogTitle + ", blogPost=" + blogPost + "]";
	}

}
