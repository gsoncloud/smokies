package com.smokies.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smokies.blog.entity.Blog;
import com.smokies.blog.exception.RecordNotFoundException;
import com.smokies.blog.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	BlogRepository repository;

	public List<Blog> getAllBlogs() {
		List<Blog> blogList = repository.findAll();

		if (blogList.size() > 0) {
			return blogList;
		} else {
			return new ArrayList<Blog>();
		}
	}

	public Blog getBlogById(Long id) throws RecordNotFoundException {
		Optional<Blog> blog = repository.findById(id);

		if (blog.isPresent()) {
			return blog.get();
		} else {
			throw new RecordNotFoundException("No blog  exist for given id");
		}
	}

	public Blog createOrUpdateBlog(Blog entity) throws RecordNotFoundException {

		Blog blog = repository.save(entity);

		return blog;
	}

	public void deleteBlogById(Long id) throws RecordNotFoundException {
		Optional<Blog> blog = repository.findById(id);

		if (blog.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No blog exist for given id");
		}
	}
}