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
import com.mtjwy.website.entity.Role;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.repository.ArticleCategoryRepository;
import com.mtjwy.website.repository.ArticleRepository;
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
	
	
	public List<WebUser> findAll() {
		return webUserRepository.findAll();
	}


	public WebUser findOne(int id) {
		return webUserRepository.findOne(id);
	}


	
	public Object findOneWithArticles(int id) {
		WebUser user = findOne(id);
		List<ArticleCategory> articleCategories= articleCategoryRepository.findByWebUser(user);
		for(ArticleCategory articleCategory : articleCategories) {
			List<Article> articles = articleRepository.findByArticleCategory(articleCategory, new PageRequest(0, 10, Direction.DESC, "publishDate"));
			articleCategory.setArticles(articles);
		}
		user.setArticleCategories(articleCategories);
		return user;
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

	
}
