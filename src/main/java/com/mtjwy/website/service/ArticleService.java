package com.mtjwy.website.service;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.entity.ArticleCategory;
import com.mtjwy.website.repository.ArticleCategoryRepository;
import com.mtjwy.website.repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ArticleCategoryService articleCategoryService;
	
	@Autowired 
	private ArticleCategoryRepository articleCategoryRepository;

	public void save(Article article) {
		articleRepository.save(article);	
	}

	public void delete(int id) {
		
		articleRepository.delete(id);
	}

	public void save(Article article, int category_id) {
		
		ArticleCategory ac = articleCategoryRepository.findOne(category_id);
		article.setPublishDate(new Date());
		article.setArticleCategory(ac);
		save(article);
		ac.getArticles().add(article);
		
	}

	public List<Article> findLatestArticles() {
		
		return articleRepository.findAll(new PageRequest(0, 20, Direction.DESC, "publishDate")).getContent();
	}

	public Article findOne(int id) {
		
		return articleRepository.findOne(id);
	}

	public List<Article> findByArticleCategory(ArticleCategory ac) {
		
		return articleRepository.findByArticleCategory(ac, new PageRequest(0, 20, Direction.DESC, "publishDate"));
	}

	public List<Article> findAdminArticles() {
		String adminName = roleService.findAdminName();
		return findArticlesByUserName(adminName);
	}
	
	public List<Article> findArticlesByUserName(String name) {
		List<ArticleCategory> categories = articleCategoryService.findByUserName(name);
		List<Article> articles = new ArrayList<Article>();  
		for (ArticleCategory c : categories) {
			articles.addAll(articleRepository.findByArticleCategory(c));
		}
		Collections.sort(articles, new Comparator<Article>() {

			public int compare(Article a1, Article a2) {
				
				return a2.getPublishDate().compareTo(a1.getPublishDate());//descending order
			}
			
		});
		
		return articles;
	}

	

	

	
	
	

}
