package com.mtjwy.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtjwy.website.entity.Blog;
import com.mtjwy.website.entity.Item;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.exception.RssException;
import com.mtjwy.website.repository.BlogRepository;
import com.mtjwy.website.repository.ItemRepository;
import com.mtjwy.website.repository.WebUserRepository;



@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private WebUserRepository webUserRepository; 
	
	@Autowired
	private RssService rssService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Scheduled(fixedDelay=60 * 60 * 1000)//1 hour = 60 min * 60 secs * 1000
	public void reloadBlogs() {
		List<Blog> blogs = blogRepository.findAll();
		for (Blog blog : blogs) {
			saveItems(blog);
		}
	}

	@Transactional
	public void save(Blog blog, String name){
		WebUser user = webUserRepository.findByName(name);
		blog.setWebUser(user);
		blogRepository.save(blog);
		saveItems(blog);
	}
	
	public void saveItems(Blog blog) {
		try {
			List<Item> items = rssService.getItems(blog.getUrl());
			
			for(Item item : items) {
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if (savedItem == null) {
					item.setBlog(blog);
					itemRepository.save(item);
				}
				
			}
		} catch (RssException e) {
			e.printStackTrace();
		}
	}

	
	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

	public void delete(int id) {
		blogRepository.delete(id);
		
	}

	@PreAuthorize("#blog.webUser.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
	}

}
