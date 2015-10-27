package com.mtjwy.website.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.entity.ArticleCategory;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	List<Article> findByArticleCategory(ArticleCategory articleCategory, Pageable pageable);

}
