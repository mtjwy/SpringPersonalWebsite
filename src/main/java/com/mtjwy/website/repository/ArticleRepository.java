package com.mtjwy.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtjwy.website.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
