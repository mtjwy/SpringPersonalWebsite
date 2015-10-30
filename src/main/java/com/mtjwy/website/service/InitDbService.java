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
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
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
		userAdmin.setEnabled(true);
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
		
		Blog blogSpring = new Blog();
		blogSpring.setName("Yahoo! NBA");
		blogSpring.setUrl("https://sports.yahoo.com/nba/rss.xml");
		
		blogSpring.setWebUser(userAdmin);
		blogRepository.save(blogSpring);
		
//		Item item1 = new Item();
//		item1.setBlog(blogSpring);
//		item1.setTitle("first");
//		item1.setLink("https://spring.io/blog");
//		item1.setPublishDate(new Date());
//		itemRepository.save(item1);
//		
//		Item item2 = new Item();
//		item2.setBlog(blogSpring);
//		item2.setTitle("second");
//		item2.setLink("https://spring.io/blog");
//		item2.setPublishDate(new Date());
//		itemRepository.save(item2);
		
		
		
		
		
		
	}
	
	
}
