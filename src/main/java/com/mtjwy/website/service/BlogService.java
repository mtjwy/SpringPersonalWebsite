package com.mtjwy.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtjwy.website.entity.Blog;
import com.mtjwy.website.repository.BlogRepository;



@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	
	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

}
