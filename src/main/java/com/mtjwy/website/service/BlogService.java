package com.mtjwy.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtjwy.website.entity.Blog;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.repository.BlogRepository;
import com.mtjwy.website.repository.WebUserRepository;



@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private WebUserRepository webUserRepository; 

	public void save(Blog blog, String name){
		WebUser user = webUserRepository.findByName(name);
		blog.setWebUser(user);
		blogRepository.save(blog);
	}
	
	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

	public void delete(int id) {
		blogRepository.delete(id);
		
	}

}
