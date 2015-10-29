package com.mtjwy.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtjwy.website.entity.ArticleCategory;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.repository.ArticleCategoryRepository;
import com.mtjwy.website.repository.WebUserRepository;

@Service
public class ArticleCategoryService {
	
	@Autowired
	ArticleCategoryRepository articleCategoryRepository;
	
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


	

}
