package com.smokies.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smokies.blog.entity.Blog;
import com.smokies.blog.exception.RecordNotFoundException;
import com.smokies.blog.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {

	@Autowired
	BlogService service;

	@GetMapping
	public ResponseEntity<List<Blog>> getAllBlogs() {
		List<Blog> list = service.getAllBlogs();

		return new ResponseEntity<List<Blog>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        Blog entity = service.getBlogById(id);
 
        return new ResponseEntity<Blog>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Blog> createOrUpdateBlog(Blog blog)
                                                    throws RecordNotFoundException {
        Blog updated = service.createOrUpdateBlog(blog);
        return new ResponseEntity<Blog>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteBlogById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        service.deleteBlogById(id);
        return HttpStatus.FORBIDDEN;
    }

}