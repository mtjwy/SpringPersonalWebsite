package com.mtjwy.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtjwy.website.entity.ArticleCategory;
import com.mtjwy.website.repository.ArticleCategoryRepository;

@Service
public class ArticleCategoryService {
	
	@Autowired
	ArticleCategoryRepository articleCategoryRepository;

	public ArticleCategory findByName(String name) {
		
		return articleCategoryRepository.findByName(name);
	}


	

}
