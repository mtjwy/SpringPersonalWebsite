package com.mtjwy.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.entity.ArticleCategory;
import com.mtjwy.website.entity.Blog;
import com.mtjwy.website.entity.Item;
import com.mtjwy.website.entity.Role;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.repository.ArticleCategoryRepository;
import com.mtjwy.website.repository.ArticleRepository;
import com.mtjwy.website.repository.BlogRepository;
import com.mtjwy.website.repository.ItemRepository;
import com.mtjwy.website.repository.RoleRepository;
import com.mtjwy.website.repository.WebUserRepository;

@Service
@Transactional
public class WebUserService {

	@Autowired
	private WebUserRepository webUserRepository;
	
	@Autowired
	private ArticleCategoryRepository articleCategoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	public List<WebUser> findAll() {
		return webUserRepository.findAll();
	}


	public WebUser findOne(int id) {
		return webUserRepository.findOne(id);
	}


	
	public WebUser findOneWithArticles(int id) {
		WebUser user = findOne(id);
		List<ArticleCategory> articleCategories= articleCategoryRepository.findByWebUser(user);
		for(ArticleCategory articleCategory : articleCategories) {
			List<Article> articles = articleRepository.findByArticleCategory(articleCategory, new PageRequest(0, 10, Direction.DESC, "publishDate"));
			articleCategory.setArticles(articles);
		}
		user.setArticleCategories(articleCategories);
		return user;
	}
	
	public WebUser findOneWithArticles(String name) {
		WebUser user = webUserRepository.findByName(name);
		return findOneWithArticles(user.getId());
	}


	public void save(WebUser user) {
		
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
				
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		webUserRepository.save(user);	
	}


	@Transactional
	public WebUser findOneWithBlogs(int id) {
		WebUser user = findOne(id);
		List<Blog> blogs = blogRepository.findByWebUser(user);
		for(Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 20, Direction.DESC, "publishDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}
	
	public WebUser findOneWithBlogs(String name) {
		WebUser user = webUserRepository.findByName(name);
		return findOneWithBlogs(user.getId());
	}


	public void delete(int id) {
		webUserRepository.delete(id);
		
	}


	public WebUser findOne(String username) {
		return webUserRepository.findByName(username);
	}
	
	

	
}
