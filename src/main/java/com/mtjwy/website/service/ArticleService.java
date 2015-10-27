package com.mtjwy.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	public void save(Article article) {
		articleRepository.save(article);	
	}

}
