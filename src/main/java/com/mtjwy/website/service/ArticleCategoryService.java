package com.mtjwy.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.entity.ArticleCategory;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.repository.ArticleCategoryRepository;
import com.mtjwy.website.repository.WebUserRepository;

@Service
public class ArticleCategoryService {
	
	@Autowired
	ArticleCategoryRepository articleCategoryRepository;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	WebUserRepository webUserRepository;

	public ArticleCategory findByName(String name) {
		
		return articleCategoryRepository.findByName(name);
	}

	public void save(ArticleCategory ac, String name) {
		WebUser user = webUserRepository.findByName(name);
		ac.setWebUser(user);
		articleCategoryRepository.save(ac);
		
	}

	public ArticleCategory findOne(int category_id) {
		return articleCategoryRepository.findOne(category_id);
	}

	public ArticleCategory findOneWithArticles(int id) {
		ArticleCategory ac = findOne(id);
		List<Article> articles = articleService.findByArticleCategory(ac);
		ac.setArticles(articles);
		
		return ac;
	}

	public List<ArticleCategory> findAll() {
		
		return articleCategoryRepository.findAll();
	}

	


	

}
