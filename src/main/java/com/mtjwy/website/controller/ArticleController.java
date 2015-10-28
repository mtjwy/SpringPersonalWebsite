package com.mtjwy.website.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	
	@ModelAttribute("article")
	public Article construct() {
		
		return new Article();
	}
	
	@RequestMapping("/new-article")
	public String showNewArticle() {
		return "new-article";
	}
	
	@RequestMapping(value="/new-article", method=RequestMethod.POST)
	public String newArticle(@ModelAttribute("article") Article article) {	
		articleService.save(article);
		return "new-article";
	}
	
	@RequestMapping("/article-category/articles/remove/{id}")
	public String removeArticle(@PathVariable int id) {
		articleService.delete(id);
		return "redirect:/article-category.html";
	}
}
