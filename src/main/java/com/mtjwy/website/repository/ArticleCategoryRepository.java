package com.mtjwy.website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.entity.ArticleCategory;
import com.mtjwy.website.entity.WebUser;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Integer>{

	List<ArticleCategory> findByWebUser(WebUser user);

	ArticleCategory findByName(String name);

	

}
