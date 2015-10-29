package com.mtjwy.website.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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

}
