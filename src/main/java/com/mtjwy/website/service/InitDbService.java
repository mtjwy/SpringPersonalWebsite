package com.mtjwy.website.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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

@Transactional
@Service
public class InitDbService {

	@Autowired
	private WebUserRepository webUserRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ArticleCategoryRepository articleCategoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@PostConstruct
	public void init() {
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		WebUser userAdmin = new WebUser();
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("123"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		webUserRepository.save(userAdmin);
		
		WebUser mtjwy = new WebUser();
		mtjwy.setName("mtjwy");
		roles = new ArrayList<Role>();
		roles.add(roleUser);
		mtjwy.setRoles(roles);
		webUserRepository.save(mtjwy);
		
		ArticleCategory articleCategoryJava = new ArticleCategory();
		articleCategoryJava.setName("java");
		articleCategoryJava.setWebUser(userAdmin);
		articleCategoryRepository.save(articleCategoryJava);
		
		Article article1 = new Article();
		article1.setArticleCategory(articleCategoryJava);
		article1.setTitle("Efective java notes");
		article1.setContent("Item1: consider use Static Factory Method to create instance.");
		article1.setPublishDate(new Date());
		articleRepository.save(article1);
		
		
		Article article2 = new Article();
		article2.setArticleCategory(articleCategoryJava);
		article2.setTitle("Java8 in action notes");
		article2.setContent("Java 8 in Action is a clearly written guide to the new features of Java 8. The book covers lambdas, streams, and functional-style programming.");
		article2.setPublishDate(new Date());
		articleRepository.save(article2);
		
		
		
		
		
		
	}
	
	
}
